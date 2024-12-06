package ru.example.myFirstProject.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class CarController {
    @Autowired
    Car car;

    @GetMapping("/car")
    public String startCar(){
        car.start();
        return "Автомобиль запущен";
    }
}
