package com.myapp.training_backend;

import com.myapp.training_backend.extractFromFileToDB.ExcelService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingBackendApplication implements CommandLineRunner {

	@Value("${project.path}")
	String path;

//	@Autowired
//	private ExcelService excelService;

	public static void main(String[] args) {
		SpringApplication.run(TrainingBackendApplication.class, args);
	}

	@Bean
	public Dotenv dotenv() {
		// Загружаем .env файл из корневой директории
		return Dotenv.configure().filename(".env").load();
	}

	//TODO delete
	@Override
	public void run(String... args) throws Exception {
//		excelService.processExcelFile(path);
		}
}
