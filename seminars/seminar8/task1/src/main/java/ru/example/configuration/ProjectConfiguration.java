package ru.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.example.aspects.LoggingAspect;

@Configuration
@ComponentScan(basePackages = "ru.example.service")
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public LoggingAspect aspect(){
        return new LoggingAspect();
    }
}
