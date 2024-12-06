package ru.example.myFirstProject.seminar2.task1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.myFirstProject.seminar2.task1.config.ProjectConfig;
import ru.example.myFirstProject.seminar2.task1.domain.Car;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Car simpleCar = context.getBean(Car.class);
//        Car simpleCar = context.getBean("BMW", Car.class);
        System.out.println(simpleCar.getModel() + ", " + simpleCar.getMade());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);
    }
}
