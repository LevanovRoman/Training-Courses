package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.response.PositionResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PositionService {

    List<PositionResponseDto> getAllPositions();

}
