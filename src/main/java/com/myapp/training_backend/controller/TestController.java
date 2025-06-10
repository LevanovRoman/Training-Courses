package com.myapp.training_backend.controller;

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
        System.out.println("CONTROLLER");
        List<PersonsCand> personsCandList = personsCandService.getPersonsByToday();
        personsCandList.forEach((el) -> System.out.println(
                el.getFullName() + " -- " + el.getTabN() + " -- " + el.getAppointName() + " -- " + el.getDeptName()
                        + " -- " + el.getCategName() + " -- "
        ));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/person")
    public String testEncoding() {
        personsCandService.getPersonsByToday();
        return "Тест русских символов: кириллица";
    }
}
