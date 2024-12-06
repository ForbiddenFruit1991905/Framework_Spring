package ru.example.myFirstProject.seminar2.task3.domain;

import org.springframework.stereotype.Component;

@Component
public class GasolineEngine implements iEngine{

    public GasolineEngine() {
        System.out.println("Создан экземпляр GasEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен Бензин 45р/л");
    }
}
