package com.myapp.training_backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrainingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingBackendApplication.class, args);
	}

	@Bean
	public Dotenv dotenv() {
		// Загружаем .env файл из корневой директории
		return Dotenv.configure().filename(".env").load();
	}
}
