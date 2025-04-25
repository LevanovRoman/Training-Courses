package com.myapp.training_backend.service;

import com.myapp.training_backend.entity.PersonsCand;

import java.time.LocalDate;
import java.util.List;

public interface PersonsCandService {

    List<PersonsCand> getPersonsByToday();
}
