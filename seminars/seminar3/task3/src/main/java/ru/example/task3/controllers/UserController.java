package ru.example.task3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.task3.domain.User;
import ru.example.task3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getUserRepository().getUsers().add(user);
        return "User added from body!";
    }

    @GetMapping("/registration")
    public User processRegistration(String name, int age, String email){
        service.processRegistration(name, age, email);
        return null;
    }
}
