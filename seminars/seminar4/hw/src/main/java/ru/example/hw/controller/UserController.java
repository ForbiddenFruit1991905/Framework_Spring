package ru.example.hw.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.example.hw.model.User;
import ru.example.hw.service.UserService;

import java.util.UUID;


@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String userAdd(@ModelAttribute("user") User u, Model model) {
        u.setId(UUID.randomUUID());
        userService.addUser(u);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

}


