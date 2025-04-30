package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.TrainingField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainingFieldRepository extends JpaRepository<TrainingField, Integer> {

    List<TrainingField> findAllByCourse(String courseStr);
}
