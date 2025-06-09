package com.myapp.training_backend.service;

import com.myapp.training_backend.entity.PersonsCand;
import com.myapp.training_backend.repository.PersonsCandRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonsCandServiceImpl implements PersonsCandService{

    private final PersonsCandRepository personsCandRepository;
    private static final Logger logger = LoggerFactory.getLogger(PersonsCandServiceImpl.class);
    private static final String LOG_FILE_PATH = "/home/logs/new_employees.log";

    @Override
    public List<PersonsCand> getPersonsByToday() {
        System.out.println("SERVICE");
        LocalDate today = LocalDate.now(); // Текущая дата
        List<PersonsCand> byDateInToday = personsCandRepository.findByDateInToday(today);
        System.out.println("BY" + byDateInToday);
        return byDateInToday;
    }

    @Scheduled(cron = "0 0 22 * * ?") // Каждый день в 22:00
    public void getNewEmployees(){
        LocalDate today = LocalDate.now();
        List<PersonsCand> newEmployees = personsCandRepository.findByDateInToday(today);

        String logMessage = String.format("[%s] New employees today: %d\n%s\n",
                today,
                newEmployees.size(),
                formatEmployees(newEmployees));

        try {
            Files.write(Paths.get(LOG_FILE_PATH),
                    logMessage.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            logger.info("Successfully logged {} new employees", newEmployees.size());
        } catch (IOException e) {
            logger.error("Failed to write to log file", e);
        }
    }

    private String formatEmployees(List<PersonsCand> newEmployees) {
        return newEmployees.stream()
                .map(e -> String.format("- %s %s (Dept: %s)",
                        e.getTabN(),
                        e.getFullName(),
                        e.getDeptName()))
                .collect(Collectors.joining("\n"));
    }
}
