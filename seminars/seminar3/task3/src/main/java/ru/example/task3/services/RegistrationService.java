package ru.example.task3.services;

import org.springframework.stereotype.Service;
import ru.example.task3.domain.User;

@Service
public class RegistrationService {

    private  DataProcessingService dataProcessingService;
    private UserService userService;
    private NotificationService notificationService;

    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public User processRegistration(String name, int age, String email) {
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createUser);
        notificationService.sendNotification("Регистрация выполнена");
        return createUser;
    }

}

/*
public void processRegistration(String name, int age, String email) {
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createUser);
//        userService.createUser(user.getName(), user.getAge(), user.getEmail());
        notificationService.sendNotification("Регистрация выполнена");
    }
 */