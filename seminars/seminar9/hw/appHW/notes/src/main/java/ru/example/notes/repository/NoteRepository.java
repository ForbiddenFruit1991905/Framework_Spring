package ru.example.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.notes.model.Note ;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
