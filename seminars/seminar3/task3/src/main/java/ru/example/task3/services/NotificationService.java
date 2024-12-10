package ru.example.task3.services;

import org.springframework.stereotype.Service;
import ru.example.task3.domain.User;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public String sendNotification(String msg) {
        return msg;
    }
}
