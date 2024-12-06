package ru.example.myFirstProject.seminar2.task2.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.example.myFirstProject.seminar2.task2.domain.Car;
import ru.example.myFirstProject.seminar2.task2.domain.Engine;

@Configuration
@ComponentScan(basePackages = "ru.example.myFirstProject.seminar2.task2.domain")
public class ProjectConfig {
    @Bean("BMW")
    Engine engine(){
        Engine engine = new Engine();
        return engine;
    }

    @Bean
    Car car(@Qualifier("engine2") Engine engine){
        Car obCar = new Car(engine);
//        obCar.setCarEngine(engine());
        obCar.setModel("S8");
        obCar.setMade("Audi");
        return obCar;
    }

    @Bean
    Engine engine1(){
        Engine engine = new Engine();
        engine.setTypeEngine("Бензиновый");
        return engine;
    }

    @Bean
    Engine engine2(){
        Engine engine = new Engine();
        engine.setTypeEngine("Дизельный");
        return engine;
    }

    @Bean
    Car car2(@Qualifier("engine1") Engine engine){
        Car obCar = new Car(engine);
//        obCar.setCarEngine(engine());
        obCar.setModel("S8");
        obCar.setMade("Audi");
        return obCar;
    }
    
}
