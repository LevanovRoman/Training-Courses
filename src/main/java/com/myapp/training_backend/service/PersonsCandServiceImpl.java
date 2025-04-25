package com.myapp.training_backend.service;

import com.myapp.training_backend.entity.PersonsCand;
import com.myapp.training_backend.repository.PersonsCandRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonsCandServiceImpl implements PersonsCandService{

    private final PersonsCandRepository personsCandRepository;

    public PersonsCandServiceImpl(PersonsCandRepository personsCandRepository) {
        this.personsCandRepository = personsCandRepository;
    }

    @Override
    public List<PersonsCand> getPersonsByToday() {
        LocalDate today = LocalDate.now(); // Текущая дата
        return personsCandRepository.findByDateInToday(today);
    }
}
