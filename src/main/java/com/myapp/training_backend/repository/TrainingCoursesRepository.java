package com.myapp.training_backend.repository;

import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCoursesList;
import com.myapp.training_backend.entity.TrainingField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingCoursesRepository extends JpaRepository<TrainingCoursesList, Long> {
    List<TrainingCoursesList> findAllByDepartmentAndPosition(Department handbookDepartment, Position handbookPosition);


    Optional<TrainingCoursesList> findByDepartmentAndPositionAndCourse(Department department, Position position, TrainingField course);
}
