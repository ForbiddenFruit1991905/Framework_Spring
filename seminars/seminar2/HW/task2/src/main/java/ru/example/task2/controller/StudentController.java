package ru.example.task2.controller;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.example.task2.model.Student;
import ru.example.task2.repository.StudentRepository;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    @Autowired // для внедрения зависимости
    public StudentController(@Qualifier("studentRepo") StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return repository.getById(id);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return (ResponseEntity<List<Student>>) repository.getAll();
    }

    @GetMapping("/student/search")
    public Student searchStudentsByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    @PostMapping("/student") // вызываться только при отправке POST запроса на соответствующий URL
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        repository.add(student.getFirstName(), student.getGroupName());
        return ResponseEntity.status(HttpStatus.CREATED).build(); // объект `ResponseEntity` с HTTP статусом `201 Created`
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (repository.deleteById(id) == repository.getById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build(); // Возвращаем HTTP статус 200 OK при успешном удалении
        } else {
            return ResponseEntity.notFound().build(); // Возвращаем HTTP статус 404 Not Found, если студент с указанным id не найден
        }
    }

    @PatchMapping("/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student){
        return repository.update(id, student);
    }
}


