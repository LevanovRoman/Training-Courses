package com.myapp.training_backend.repository;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.entity.HandbookDepartment;
import com.myapp.training_backend.entity.HandbookPosition;
import com.myapp.training_backend.entity.TrainingCoursesList;
import com.myapp.training_backend.entity.TrainingField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainingCoursesRepository extends JpaRepository<TrainingCoursesList, Long> {
    List<TrainingCoursesList> findAllByDepartmentAndPosition(HandbookDepartment handbookDepartment, HandbookPosition handbookPosition);


    Optional<TrainingCoursesList> findByDepartmentAndPositionAndCourse(HandbookDepartment department, HandbookPosition position, TrainingField course);
}
