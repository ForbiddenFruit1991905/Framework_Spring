package ru.example.task3.models;

import lombok.Data;

@Data // генерация геттеров и сеттеров
public class Product {
    private String name;
    private double price;
    
}
