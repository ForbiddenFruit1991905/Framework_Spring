package ru.example.task3.repository;

import org.springframework.stereotype.Component;
import ru.example.task3.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private List<User> users;

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public UserRepository() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

}


    

