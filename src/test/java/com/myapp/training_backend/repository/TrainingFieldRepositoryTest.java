package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.TrainingField;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class TrainingFieldRepositoryTest {

    @Autowired
    TrainingFieldRepository trainingFieldRepository;

    @BeforeEach
    public void setUp(){
        TrainingField trainingField1 = TrainingField.builder().id(1).course("courseName").build();
        TrainingField trainingField2 = TrainingField.builder().id(2).course("courseName").build();
        trainingFieldRepository.save(trainingField1);
        trainingFieldRepository.save(trainingField2);
    }

    @Test
    void TrainingFieldRepository_FindById_ReturnTrainingField() {
        TrainingField trainingFieldFounded = trainingFieldRepository.findById(1).get();

        Assertions.assertThat(trainingFieldFounded).isNotNull();
    }

    @Test
    void TrainingFieldRepository_FindAll_ReturnMoreThanOne() {
        List<TrainingField> trainingFieldList = trainingFieldRepository.findAll();

        Assertions.assertThat(trainingFieldList).isNotNull();
        Assertions.assertThat(trainingFieldList.size()).isEqualTo(2);
    }

    @Test
    void TrainingFieldRepository_FindAllByCourse_ReturnMoreThanOne() {
        List<TrainingField> trainingFieldList = trainingFieldRepository.findAllByCourse("courseName");

        Assertions.assertThat(trainingFieldList).isNotNull();
        Assertions.assertThat(trainingFieldList.size()).isEqualTo(2);
    }
}