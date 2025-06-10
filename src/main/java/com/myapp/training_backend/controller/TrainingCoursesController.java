package com.myapp.training_backend.controller;

import com.myapp.training_backend.dto.CoursesDto;
import com.myapp.training_backend.dto.RequestDto;
import com.myapp.training_backend.dto.request.OneSRequestDto;
import com.myapp.training_backend.dto.response.DepartmentResponseDto;
import com.myapp.training_backend.dto.response.PositionResponseDto;
import com.myapp.training_backend.service.DepartmentService;
import com.myapp.training_backend.service.OneSService;
import com.myapp.training_backend.service.PositionService;
import com.myapp.training_backend.service.TrainingCoursesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class TrainingCoursesController {

    private static final Logger logger = LoggerFactory.getLogger(TrainingCoursesController.class);

    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final TrainingCoursesService trainingCoursesService;
    private final OneSService oneSService;

    @GetMapping("/all-departments")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/all-positions")
    public ResponseEntity<List<PositionResponseDto>> getAllPositions(){
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @PostMapping("/transfer-to-1s")
    public ResponseEntity<String> transferDataTo1s(@RequestBody OneSRequestDto oneSRequestDto){
        logger.info("The object was received {}", oneSRequestDto.author());
        boolean success = oneSService.transferDataTo1s(oneSRequestDto);
        if (success) {
            logger.info("The file has been sent");
            return ResponseEntity.ok("Файл отправлен в 1С");
        } else {
            logger.info("Error when sending");
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Ошибка при отправке в 1С");
        }
    }

//  TEST
    // { departmentId: selected1, positionId: selected2 }

    @PostMapping("/result")
    public ResponseEntity<List<CoursesDto>> getResult(@RequestBody RequestDto request){
        return ResponseEntity.ok(trainingCoursesService.getResult(request));
    }
}
