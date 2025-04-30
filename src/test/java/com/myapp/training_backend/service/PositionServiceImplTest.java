package com.myapp.training_backend.service;

import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PositionServiceImplTest {

    @Mock
    PositionRepository positionRepository;

    @InjectMocks
    PositionServiceImpl positionService;

    @Test
    void testGetAllPositions_ReturnsListOfPositions() {
        Position position1 = Position.builder().id(1).name("manager").build();
        Position position2 = Position.builder().id(1).name("director").build();
        List<Position> mockPositions = List.of(position1, position2);




    }
}