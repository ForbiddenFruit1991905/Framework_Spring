package ru.example.task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Task1Application {
	/*
	Задание: Используя Spring Boot, создайте простое
	веб-приложение, которое приветствует пользователя
	на главной странице.
	 */
	public static void main(String[] args) {

		SpringApplication.run(Task1Application.class, args);
	}

	@RestController
	class WelcomeController {

		@GetMapping("/welcome")
		public String welcome(){
			return "Hello and Welcome!";
		}
	}

}
