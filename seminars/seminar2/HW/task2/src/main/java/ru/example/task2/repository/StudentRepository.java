package ru.example.task2.repository;

import org.springframework.stereotype.Component;
import ru.example.task2.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {
    private final List<Student> studentList;
    private static int idCounter = 1;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("Vika", "12345"));
        studentList.add(new Student("User #2", "12345"));
        studentList.add(new Student("User #3", "12345"));
        studentList.add(new Student("User #4", "79345"));
        studentList.add(new Student("User #5", "79345"));
    }

    public void add(String firstName, String groupName){
        Student student = new Student(idCounter++, firstName, groupName);
        studentList.add(student);
    }

    public List<Student> getAll() {
        return List.copyOf(studentList);
    }

    public Student getByName(String name) {
        return studentList.stream()
                        .filter(n -> Objects.equals(n.getFirstName(), name))
                        .findFirst().orElse(null);
//                Objects.equals(name, studentList.getFirst().getFirstName());
    }

    public Student getById (int id){
        return studentList.stream()
                .filter(n -> Objects.equals(n.getId(), id))
                .findFirst().orElse(null);
    }

    public Student deleteById (int id){
        return studentList.stream()
                .filter(n -> Objects.equals(n.getId(), id))
                .findFirst()
                .map(student -> { studentList.remove(student); return student; })
                .orElse(null);
    }

    public Student update(int id, Student updatedStudent) {
        return studentList.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .map(foundStudent -> {
                    foundStudent.setFirstName(updatedStudent.getFirstName());
                    foundStudent.setGroupName(updatedStudent.getGroupName());
                    return foundStudent;
                })
                .orElseThrow(() -> new IllegalArgumentException("Студент с указанным идентификатором не найден"));
    }

}
