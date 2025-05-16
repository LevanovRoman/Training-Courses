package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.response.PositionResponseDto;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.repository.PositionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PositionServiceImplTest {

    @Mock
    PositionRepository positionRepository;

    @InjectMocks
    PositionServiceImpl positionService;

    @Test
    void testGetAllPositions_ReturnsListOfPositions() {
        // Подготовка
        Position position1 = Position.builder().id(1).name("manager").build();
        Position position2 = Position.builder().id(2).name("director").build();
        List<Position> mockPositions = List.of(position1, position2);
        // Мокируем
        when(positionRepository.findAll()).thenReturn(mockPositions);
        // Вызываем
        List<PositionResponseDto> result = positionService.getAllPositions();
        // Проверяем
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).name()).isEqualTo("manager");
        Assertions.assertThat(result.get(1).name()).isEqualTo("director");

    }
}