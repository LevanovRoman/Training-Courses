package com.myapp.training_backend.controller;

import com.myapp.training_backend.dto.FileTestRequest;
import com.myapp.training_backend.dto.response.DepartmentResponseDto;
import com.myapp.training_backend.entity.PersonsCand;
import com.myapp.training_backend.service.PersonsCandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private final PersonsCandService personsCandService;

    public TestController(PersonsCandService personsCandService) {
        this.personsCandService = personsCandService;
    }

    @GetMapping("/today")
    public ResponseEntity<String> getAllDepartments(){
        List<PersonsCand> personsCandList = personsCandService.getPersonsByToday();
        personsCandList.forEach((el) -> System.out.println(
                el.getFullName() + " -- " + el.getTabN() + " -- " + el.getAppointName() + " -- " + el.getDeptName()
                        + " -- " + el.getCategName() + " -- "
        ));
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/file")
    public ResponseEntity<String> receiveFile(@RequestBody FileTestRequest fileTestRequest){
        System.out.println("FIO   " + fileTestRequest.fio());
        System.out.println("FILE NAME   " + fileTestRequest.filename());
        System.out.println("FILE BASE   " + fileTestRequest.filedata());
//        boolean success = oneCService.sendFileTo1C(fileRequest);
//        if (success) {
//            return ResponseEntity.ok("Файл отправлен в 1С");
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Ошибка при отправке в 1С");
//        }
        return ResponseEntity.ok("Файл отправлен в 1С");
    }
}
