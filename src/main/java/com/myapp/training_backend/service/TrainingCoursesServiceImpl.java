package com.myapp.training_backend.service;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.dto.TrainingFieldDto;
import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCourse;
import com.myapp.training_backend.exceptions.ObjectNotFoundException;
import com.myapp.training_backend.repository.DepartmentRepository;
import com.myapp.training_backend.repository.PositionRepository;
import com.myapp.training_backend.repository.TrainingCourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCoursesServiceImpl implements TrainingCoursesService {

    private final TrainingCourseRepository trainingCoursesRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    public TrainingCoursesServiceImpl(TrainingCourseRepository trainingCoursesRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository) {
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

    @Override
    public List<TrainingFieldDto> getTrainingFieldIds(RequestDto requestDto) {
        Department handbookDepartment = departmentRepository.findById(requestDto.departmentId())
                .orElseThrow(() -> new ObjectNotFoundException("Department not found"));
        Position handbookPosition = positionRepository.findById(requestDto.positionId())
                .orElseThrow(() -> new ObjectNotFoundException("Position not found"));
        List<TrainingFieldDto> trainingFieldDtoList = trainingCoursesRepository.findAllByDepartmentAndPosition(handbookDepartment, handbookPosition)
                .stream().map(this::convertToTrainingFieldDto).toList();
        return trainingFieldDtoList;
    }

    private CoursesDto convertToCoursesDto(TrainingCourse trainingCourse) {
        return new CoursesDto(trainingCourse.getCourse().getCourse());
    }

    private TrainingFieldDto convertToTrainingFieldDto(TrainingCourse trainingCourse) {
        return new TrainingFieldDto(trainingCourse.getCourse().getId());
    }

}
