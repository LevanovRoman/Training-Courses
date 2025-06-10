package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.request.TrainingResultRequestDto;
import com.myapp.training_backend.dto.response.TrainingResultResponseDto;

public interface TrainingResultService {

    String createListCoursesForNewEmployees (TrainingResultRequestDto trainingResultRequestDto);
}
