package ru.example.myFirstProject.seminar2.task1.domain;

import org.springframework.stereotype.Service;

@Service
public class Car {
    private String model;
    private String made;

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
    
}
