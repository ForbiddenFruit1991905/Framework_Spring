package ru.example.task2.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonCreator;

@Data
public class Student {
    private static long idCounter = 1L;

    private long id;
    private String firstName;
    private String groupName;

    @JsonCreator
    public Student(long id, String firstName, String groupName) {
        this.id = id;
        this.firstName = firstName;
        this.groupName = groupName;
    }

    public Student(String firstName) {
        this.id = idCounter++;
        this.firstName = firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public long getId() {
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
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
