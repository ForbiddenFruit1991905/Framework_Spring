package ru.example.task2.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.task2.model.Reader;

@Repository
public interface ReaderRepo extends JpaRepository<Reader, Long> {
}
