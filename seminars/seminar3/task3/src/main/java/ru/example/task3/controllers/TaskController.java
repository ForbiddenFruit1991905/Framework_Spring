package ru.example.task3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.task3.domain.User;
import ru.example.task3.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }
    
    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        List<User> users = service.getUserRepository().getUsers();
        return service.filterUsersByAge(users, age);
//        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAvgAge(){
        List<User> users = service.getUserRepository().getUsers();
        return service.calculateAverageAge(users);
//        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }

}
