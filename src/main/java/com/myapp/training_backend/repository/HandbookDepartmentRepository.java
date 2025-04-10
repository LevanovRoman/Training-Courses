package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.HandbookDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandbookDepartmentRepository extends JpaRepository<HandbookDepartment, Integer> {
}
