package ru.example.task2.configure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.example.task2.repository.StudentRepository;

@Configuration
public class AppConf {

    @Bean
    @Qualifier("studentRepo") // Добавила аннотацию @Qualifier с уникальным именем бина
    StudentRepository studentRepo(){
        return new StudentRepository();
    }
}
