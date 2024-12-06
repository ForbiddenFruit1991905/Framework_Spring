package ru.example.myFirstProject.seminar2.task4.CRUDSpringWEB.src.main.java.org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.example.myFirstProject.seminar2.task4.CRUDSpringWEB.src.main.java.org.example.config.ProjectConfig;
import ru.example.myFirstProject.seminar2.task4.CRUDSpringWEB.src.main.java.org.example.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);
        boolean b1 = cs1 == cs2;
        System.out.println(b1);
        System.out.println(cs1);
        System.out.println(cs2);
    }
}