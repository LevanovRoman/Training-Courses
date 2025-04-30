package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCourse;
import com.myapp.training_backend.entity.TrainingField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingCourseRepository extends JpaRepository<TrainingCourse, Long> {

    List<TrainingCourse> findAllByDepartmentAndPosition(Department handbookDepartment,
                                                        Position handbookPosition);

    Optional<TrainingCourse> findByDepartmentAndPositionAndCourse(Department department,
                                                                  Position position,
                                                                  TrainingField course);
}
