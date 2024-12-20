package ru.example.hw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/private-data")
    public String getPrivateData() {
        return "Это приватная информация, доступная только для администраторов.";
    }

    @GetMapping("/public-data")
    public String getPublicData() {
        return "Это открытая информация, доступная для всех зарегистрированных пользователей.";
    }

    @GetMapping("/login")
    public String auth(){
        return "login";
    }

}


