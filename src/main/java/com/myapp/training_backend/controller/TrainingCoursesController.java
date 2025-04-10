package com.myapp.training_backend.controller;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.dto.ResponseDto;
import com.myapp.training_backend.entity.HandbookDepartment;
import com.myapp.training_backend.entity.HandbookPosition;
import com.myapp.training_backend.entity.TrainingCoursesList;
import com.myapp.training_backend.repository.HandbookDepartmentRepository;
import com.myapp.training_backend.repository.HandbookPositionRepository;
import com.myapp.training_backend.repository.TrainingCoursesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class TrainingCoursesController {

    private final TrainingCoursesRepository trainingCoursesRepository;
    private final HandbookPositionRepository handbookPositionRepository;
    private final HandbookDepartmentRepository handbookDepartmentRepository;

    public TrainingCoursesController(TrainingCoursesRepository trainingCoursesRepository, HandbookPositionRepository handbookPositionRepository, HandbookDepartmentRepository handbookDepartmentRepository) {
        this.trainingCoursesRepository = trainingCoursesRepository;
        this.handbookPositionRepository = handbookPositionRepository;
        this.handbookDepartmentRepository = handbookDepartmentRepository;
    }

    @GetMapping("/test")
    public ResponseEntity<List<ResponseDto>> getRequest(){
        List<TrainingCoursesList> allCourses = trainingCoursesRepository.findAll();
        return ResponseEntity.ok(allCourses.stream().map(this::convertToDto).toList());
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CoursesDto>> getCoursesByDepartmentAndPosition(@RequestParam int departmentId,
                                                                              @RequestParam int positionId){
        System.out.println("CONTROLLER");
        HandbookDepartment handbookDepartment = handbookDepartmentRepository.findById(departmentId).orElseThrow();
        HandbookPosition handbookPosition = handbookPositionRepository.findById(positionId).orElseThrow();
        List<CoursesDto> coursesDtoList = trainingCoursesRepository.findAllByDepartmentAndPosition(handbookDepartment, handbookPosition)
                .stream().map(this::convertToCoursesDto).toList();
        return ResponseEntity.ok(coursesDtoList);
    }

    private CoursesDto convertToCoursesDto(TrainingCoursesList trainingCourse) {
        return new CoursesDto(trainingCourse.getCourse().getCourse());
    }

    private ResponseDto convertToDto(TrainingCoursesList course) {
        return new ResponseDto(course.getDepartment().getId(),
                course.getPosition().getId(),
                course.getCourse().getId());
    }
}
