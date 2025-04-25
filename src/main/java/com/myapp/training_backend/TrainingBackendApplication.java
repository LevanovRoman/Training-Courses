package com.myapp.training_backend;

import com.myapp.training_backend.transit.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrainingBackendApplication implements CommandLineRunner {

	@Value("${project.path}")
	String path;

	@Autowired
	private ExcelService excelService;

	public static void main(String[] args) {
		SpringApplication.run(TrainingBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		excelService.processExcelFile(path);
		}
}
