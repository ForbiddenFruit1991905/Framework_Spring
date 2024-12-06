package ru.example.myFirstProject.seminar2.task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.myFirstProject.seminar2.task3.config.ProjectConfig;
import ru.example.myFirstProject.seminar2.task3.domain.Car;
import ru.example.myFirstProject.seminar2.task3.domain.DiselEngine;


public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car c = context.getBean(Car.class);
        c.go();

        System.out.println("--------------------------------------");
        DiselEngine diselEngine = context.getBean(DiselEngine.class);
    }
}
