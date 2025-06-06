package com.myapp.training_backend.service;

import com.myapp.training_backend.entity.PersonsCand;
import com.myapp.training_backend.repository.PersonsCandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsCandServiceImpl implements PersonsCandService{

    private final PersonsCandRepository personsCandRepository;

    @Override
    public List<PersonsCand> getPersonsByToday() {
        System.out.println("SERVICE");
        LocalDate today = LocalDate.now(); // Текущая дата
        List<PersonsCand> byDateInToday = personsCandRepository.findByDateInToday(today);
        System.out.println("BY" + byDateInToday);
        return byDateInToday;
    }
}
