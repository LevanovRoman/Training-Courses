package com.myapp.training_backend.extractFromFileToDB;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/extract")
@RequiredArgsConstructor
public class ExtractController {

    @Value("${project.path}")
    String path;

    private final ExcelService excelService;

    @GetMapping("/{departmentId}")
    public ResponseEntity<String> extractFromFileToDb(@PathVariable("departmentId") String departmentId){
        try{
            excelService.processExcelFile(path);
            return ResponseEntity.ok("Success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
