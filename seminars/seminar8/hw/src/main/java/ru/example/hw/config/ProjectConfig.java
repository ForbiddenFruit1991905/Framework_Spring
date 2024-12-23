package ru.example.hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.example.hw.aspects.LogAspect;

@Configuration
//@ComponentScan(basePackages = "ru.example.hw.service.impl")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LogAspect aspect(){
        return new LogAspect();
    }
}
