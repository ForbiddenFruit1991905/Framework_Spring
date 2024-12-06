package ru.example.myFirstProject.seminar2.task3.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class Car {
    private String model = "BMW";
    private String made = "X1";

    @Autowired
    private iEngine carEngine;

    public Car(iEngine engine){
        this.carEngine = engine;
        System.out.println("Автомобиль создан!");
    }

    public iEngine getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(iEngine carEngine) {
        this.carEngine = carEngine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", made='" + made + '\'' +
                '}';
    }

    public void go(){
        carEngine.startEngine();
    }
}
