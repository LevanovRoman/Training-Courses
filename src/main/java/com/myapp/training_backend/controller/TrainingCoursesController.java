package com.myapp.training_backend.controller;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.dto.response.DepartmentResponseDto;
import com.myapp.training_backend.dto.ResponseDto;
import com.myapp.training_backend.dto.response.PositionResponseDto;
import com.myapp.training_backend.entity.Department;
import com.myapp.training_backend.entity.Position;
import com.myapp.training_backend.entity.TrainingCoursesList;
import com.myapp.training_backend.repository.DepartmentRepository;
import com.myapp.training_backend.repository.PositionRepository;
import com.myapp.training_backend.repository.TrainingCoursesRepository;
import com.myapp.training_backend.service.DepartmentService;
import com.myapp.training_backend.service.PositionService;
import com.myapp.training_backend.service.TrainingCoursesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class TrainingCoursesController {

    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final TrainingCoursesService trainingCoursesService;

    public TrainingCoursesController(DepartmentService departmentService, PositionService positionService, TrainingCoursesService trainingCoursesService) {
        this.departmentService = departmentService;
        this.positionService = positionService;
        this.trainingCoursesService = trainingCoursesService;
    }

    @GetMapping("/all-departments")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/all-positions")
    public ResponseEntity<List<PositionResponseDto>> getAllPositions(){
        return ResponseEntity.ok(positionService.getAllPositions());
    }

//  TEST
    // { departmentId: selected1, positionId: selected2 }

    @PostMapping("/result")
    public ResponseEntity<List<CoursesDto>> getResult(@RequestBody RequestDto request){
        return ResponseEntity.ok(trainingCoursesService.getResult(request));
    }

//    @GetMapping("/test")
//    public ResponseEntity<List<ResponseDto>> getRequest(){
//        List<TrainingCoursesList> allCourses = trainingCoursesRepository.findAll();
//        return ResponseEntity.ok(allCourses.stream().map(this::convertToDto).toList());
//    }
//
//    @GetMapping("/courses")
//    public ResponseEntity<List<CoursesDto>> getCoursesByDepartmentAndPosition(@RequestParam int departmentId,
//                                                                              @RequestParam int positionId){
//        System.out.println("CONTROLLER");
//        Department handbookDepartment = departmentRepository.findById(departmentId).orElseThrow();
//        Position handbookPosition = positionRepository.findById(positionId).orElseThrow();
//        List<CoursesDto> coursesDtoList = trainingCoursesRepository.findAllByDepartmentAndPosition(handbookDepartment, handbookPosition)
//                .stream().map(this::convertToCoursesDto).toList();
//        return ResponseEntity.ok(coursesDtoList);
//    }
//
//    private CoursesDto convertToCoursesDto(TrainingCoursesList trainingCourse) {
//        return new CoursesDto(trainingCourse.getCourse().getCourse());
//    }
//
//    private ResponseDto convertToDto(TrainingCoursesList course) {
//        return new ResponseDto(course.getDepartment().getId(),
//                course.getPosition().getId(),
//                course.getCourse().getId());
//    }
}
