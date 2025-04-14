package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCoursesList;
import com.myapp.training_backend.exceptions.ObjectNotFoundException;
import com.myapp.training_backend.repository.DepartmentRepository;
import com.myapp.training_backend.repository.PositionRepository;
import com.myapp.training_backend.repository.TrainingCoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCoursesServiceImpl implements TrainingCoursesService {

    private final TrainingCoursesRepository trainingCoursesRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    public TrainingCoursesServiceImpl(TrainingCoursesRepository trainingCoursesRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository) {
        this.trainingCoursesRepository = trainingCoursesRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<CoursesDto> getResult(RequestDto requestDto) {
        Department handbookDepartment = departmentRepository.findById(requestDto.departmentId())
                .orElseThrow(() -> new ObjectNotFoundException("Department not found"));
        Position handbookPosition = positionRepository.findById(requestDto.positionId())
                .orElseThrow(() -> new ObjectNotFoundException("Position not found"));
        List<CoursesDto> coursesDtoList = trainingCoursesRepository.findAllByDepartmentAndPosition(handbookDepartment, handbookPosition)
                .stream().map(this::convertToCoursesDto).toList();
        return coursesDtoList;
    }

    private CoursesDto convertToCoursesDto(TrainingCoursesList trainingCourse) {
        return new CoursesDto(trainingCourse.getCourse().getCourse());
    }

}
