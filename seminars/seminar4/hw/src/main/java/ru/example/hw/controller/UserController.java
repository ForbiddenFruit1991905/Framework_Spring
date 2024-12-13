package ru.example.hw.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.example.hw.model.User;
import ru.example.hw.service.UserService;


@Controller
//@AllArgsConstructor
public class UserController {

//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
//        List<User> users = userService.getAllUsers();
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

//    @PostMapping("/users")
//    public String userAdd(@RequestBody Map<String, Object> requestBody) {
//        String name = (String) requestBody.get("name");
//        Integer age = (Integer) requestBody.get("age");
//        String email = (String) requestBody.get("email");
//
//        userService.addUser(name, age, email);
//        return "User added from body!";
//    }

    @PostMapping("/users")
    public String userAdd
//            (@RequestBody Map<String, Object> requestBody) {
//        String name = (String) requestBody.get("name");
//        Integer age = (Integer) requestBody.get("age");
//        String email = (String) requestBody.get("email");

            (User u, Model model) {
        userService.addUser(u);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


}


