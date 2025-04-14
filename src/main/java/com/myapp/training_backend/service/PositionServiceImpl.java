package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.response.PositionResponseDto;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionResponseDto> getAllPositions() {
        return positionRepository.findAll()
                .stream()
                .map(this::convertPositionToPositionResponseDto)
                .toList();
    }

    private PositionResponseDto convertPositionToPositionResponseDto(Position position) {
        return new PositionResponseDto(position.getId(), position.getName());
    }
}
