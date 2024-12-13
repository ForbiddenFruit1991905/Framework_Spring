package ru.example.hw.service;

import org.springframework.stereotype.Service;
import ru.example.hw.model.User;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
