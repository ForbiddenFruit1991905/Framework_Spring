package ru.example.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.task2.configure.AppConf;
import ru.example.task2.controller.StudentController;
import ru.example.task2.model.Student;

@SpringBootApplication
public class Task2Application {
	/**
	 * 1. Создать spring-boot приложение с помощью https://start.spring.io/
	 * 2. Создать Класс Student c полями: идентификатор, имя, имя группы
	 * 3. Создать контроллер, обрабатывающий входящие запросы:
	 * 3.1 GET /student/{id} - получить студента по ID
	 * 3.2 GET /student - получить всех студентов
	 * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
	 * 3.4 GET /group/{groupName}/student - получить всех студентов группы
	 * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
	 * 3.6 DELETE /student/{id} - удалить студента
	 * 4. При старте приложения, в программе должно быть создано 5-10 студентов.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Task2Application.class, args);

		// Инициализируем контекст Spring
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

		// Получаем экземпляр StudentController из контекста
		StudentController studentController = context.getBean(StudentController.class);

		// Вызываем методы контроллера для проверки их функциональности
		studentController.getAllStudents();
		studentController.getStudentById(Long.valueOf(2));
		studentController.createStudent(new Student("Ван Дун'Эр"));
		studentController.updateStudent(1, new Student("Хо Юхао"));
		studentController.deleteStudent(Long.valueOf(1));
	}
}
