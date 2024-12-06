package ru.example.myFirstProject.seminar2.task2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.myFirstProject.seminar2.task2.config.ProjectConfig;
import ru.example.myFirstProject.seminar2.task2.domain.Car;
import ru.example.myFirstProject.seminar2.task2.domain.Engine;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car c = context.getBean(Car.class);
        Engine e = context.getBean(Engine.class);
        System.out.println(c);
        System.out.println(e);
    }
}
