package ru.example.myFirstProject.seminar2.task1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.example.myFirstProject.seminar2.task1.domain.Car;

@Configuration
public class ProjectConfig {
    @Bean("BMW")
    Car car1(){
        Car obCar = new Car();
        obCar.setModel("X1");
        obCar.setMade("BMW");
        return obCar;
    }

    @Bean(name="Audi")
    Car car2(){
        Car obCar = new Car();
        obCar.setModel("S8");
        obCar.setMade("Audi");
        return obCar;
    }

    @Bean
    @Primary
    Car car3(){
        Car obCar = new Car();
        obCar.setModel("H7");
        obCar.setMade("Haval");
        return obCar;
    }

    @Bean
    String hello(){
        return "Hello";
    }

    @Bean
    Integer ten(){
        return 10;
    }
}
