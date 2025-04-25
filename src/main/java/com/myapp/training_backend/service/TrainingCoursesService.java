package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.dto.request.OneSRequestDto;

import java.util.List;

public interface TrainingCoursesService {

    List<CoursesDto> getResult(RequestDto requestDto);
}
