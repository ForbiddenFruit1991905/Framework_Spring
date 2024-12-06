package ru.example.myFirstProject.seminar2.task3.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DiselEngine implements iEngine{

    public DiselEngine() {
        System.out.println("Создан экземпляр DieselEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен Дизель 65р/л");
    }
}
