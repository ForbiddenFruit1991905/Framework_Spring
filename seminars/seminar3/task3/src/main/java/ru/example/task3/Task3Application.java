package ru.example.task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.task3.controllers.TaskController;
import ru.example.task3.controllers.UserController;
import ru.example.task3.domain.User;

@SpringBootApplication
public class Task3Application {

	public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Task3Application.class);

		UserController userController = context.getBean(UserController.class);
		TaskController taskController = context.getBean(TaskController.class);

		userController.processRegistration("Dima", 34, "dima@example.com");
		userController.processRegistration("Vika", 33, "vika@example.com");

		// Вывод пользователей после добавления
		System.out.println("Users after addition: " + userController.userList());

		// 1. Получить список всех задач
		System.out.println("All tasks: " + taskController.getAllTasks());

		// 2. Сортировать пользователей по возрасту
		System.out.println("Sorted users by age: " + taskController.sortUserByAge());

		// 3. Фильтровать пользователей по возрасту (например, возраст > 33)
		System.out.println("Users filtered by age: " + taskController.filterUsersByAge(33));

		// 4. Рассчитать средний возраст пользователей
		System.out.println("Average age of users: " + taskController.calculateAvgAge());

		context.close();

	}

}
