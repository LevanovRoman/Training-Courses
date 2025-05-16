package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PositionRepositoryTest {

    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    public void setUp(){
        Position position1 = Position.builder()
                .id(1)
                .name("Test_Position")
                .build();
        Position position2 = Position.builder()
                .id(2)
                .name("test_position")
                .build();
        positionRepository.save(position1);
        positionRepository.save(position2);
    }

    @Test
    public void PositionRepository_FindById_ReturnPosition(){
        Position positionFounded = positionRepository.findById(1).get();

        Assertions.assertThat(positionFounded).isNotNull();
    }

    @Test
    public void PositionRepository_FindAllPositions_ReturnMoreThanOnePosition(){
        List<Position> positionList = positionRepository.findAll();

        Assertions.assertThat(positionList).isNotNull();
        Assertions.assertThat(positionList.size()).isEqualTo(2);
    }

    @Test
    public void PositionRepository_FindAllByNameIgnoreCase_ReturnPositions() {
        List<Position> positionList = positionRepository.findAllByNameIgnoreCase("test_Position");

        Assertions.assertThat(positionList).isNotNull();
        Assertions.assertThat(positionList.size()).isEqualTo(2);
    }
}