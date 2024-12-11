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
    public User processRegistration(String name, Integer age, String email){
//        return service.processRegistration(name, age, email);
        List<User> existingUsers = service.getDataProcessingService().getUserRepository().getUsers();
        for (User user : existingUsers) {
            if (user.getEmail().equals(email)) {
                System.out.println("User with email " + email + " already exists.");
                return user;
            }
        }

        User newUser = service.processRegistration(name, age, email);
        userAddFromBody(newUser);
        return newUser;
    }

}
