package ru.example.task2.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonCreator;

@Data
public class Student {
    private static int idCounter = 1;

    private int id;
    private String firstName;
    private String groupName;

    @JsonCreator
    public Student(int id, String firstName, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.groupName = groupName;
    }

    public Student(String firstName, String groupName) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.groupName = groupName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "\n" +"Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
