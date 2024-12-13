package ru.example.hw.model;

import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int age;
    private String email;

}
