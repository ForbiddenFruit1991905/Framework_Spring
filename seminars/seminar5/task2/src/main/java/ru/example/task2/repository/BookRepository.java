package ru.example.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.task2.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
