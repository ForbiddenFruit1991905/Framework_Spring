package ru.example.myFirstProject.seminar2.task4.CRUDSpringWEB.src.main.java.org.example.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.example.myFirstProject.seminar2.task4.CRUDSpringWEB.src.main.java.org.example.services.CommentService;

@Configuration
public class ProjectConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService(){
        return new CommentService();
    }
}
