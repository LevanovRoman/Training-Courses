package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.request.TrainingResultRequestDto;
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
    private final TrainingResultService trainingResultService;

    private static final Logger logger = LoggerFactory.getLogger(PersonsCandServiceImpl.class);
    private static final String LOG_FILE_PATH = "/home/logs/new_employees.log";

    @Override
    public List<PersonsCand> getPersonsByToday() {
        System.out.println("SERVICE");
        List<PersonsCand> newEmployees = personsCandRepository.findNewEmployeeByToday();

        List<String> resultList = newEmployees.stream()
                .map(this::createListCoursesForNewEmployees).toList();

        String logMessage = String.format("[%s] New employees today: %d\n%s\n%s\n",
                LocalDate.now(),
                newEmployees.size(),
                formatEmployees(newEmployees),
                formatResultList(resultList));

        logger.info("Successfully logged {} new employees",
                        newEmployees.size());
        logger.info("[{}] New employees today: {}\n{}\n{}\n",
                LocalDate.now(), newEmployees.size(), formatEmployees(newEmployees), formatResultList(resultList));

        return newEmployees;
    }

    @Scheduled(cron = "0 0 21 * * ?") // Каждый день в 22:00
    public void getNewEmployees(){
//        LocalDate today = LocalDate.now();
//        List<PersonsCand> newEmployees = personsCandRepository.findByDateInToday(today);

        // получаем список новых работников за текущий день
        List<PersonsCand> newEmployees = personsCandRepository.findNewEmployeeByToday();

//        List<TrainingResultRequestDto> trainingResultRequestDtoList = newEmployees
//                .stream()
//                .map(this::convertPersonsCandToTrainingResultRequestDto).toList();

        List<String> resultList = newEmployees.stream()
                .map(this::createListCoursesForNewEmployees).toList();

        String logMessage = String.format("[%s] New employees today: %d\n%s\n%s\n",
                LocalDate.now(),
                newEmployees.size(),
                formatEmployees(newEmployees),
                formatResultList(resultList));

        try {
            Files.write(Paths.get(LOG_FILE_PATH),
                    logMessage.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            if (logger.isInfoEnabled()) {
                logger.info("Successfully logged {} new employees",
                        newEmployees.size());
            }
        } catch (IOException e) {
            logger.error("Failed to write to log file", e);
        }
    }

    private String createListCoursesForNewEmployees(PersonsCand personsCand) {
        TrainingResultRequestDto trainingResultRequestDto = new TrainingResultRequestDto(
                personsCand.getId(),
                personsCand.getActualDeptRootId(),
                personsCand.getAppointId());
        String result = trainingResultService.createListCoursesForNewEmployees(trainingResultRequestDto);
        return result;
    }

//    private TrainingResultRequestDto convertPersonsCandToTrainingResultRequestDto(PersonsCand personsCand) {
//        return new TrainingResultRequestDto(
//                personsCand.getId(),
//                personsCand.getActualDeptRootId(),
//                personsCand.getAppointId()
//                );
//    }

    private String formatEmployees(List<PersonsCand> newEmployees) {
        return newEmployees.stream()
                .map(e -> String.format("- %s %s (Dept: %s)",
                        e.getTabN(),
                        e.getFullName(),
                        e.getDeptName()))
                .collect(Collectors.joining("\n"));
    }

    private String formatResultList(List<String> resultList) {
        return resultList.stream()
                .map(e -> String.format("-- %s", e))
                .collect(Collectors.joining("\n"));
    }
}
