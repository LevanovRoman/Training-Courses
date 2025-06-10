package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.TrainingResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingResultRepository extends JpaRepository<TrainingResult, Integer> {
}
