package ru.example.task3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        tasks.add("/tasks/sort");
        tasks.add("/tasks/filter");
        tasks.add("/tasks/calc");
        return tasks;
    }
    
    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(int age){
        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAvgAge(){
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }

    @GetMapping("/addNewUser")
    public void addUserToList(User user){
        service.addUserToList(user);
    }

}
