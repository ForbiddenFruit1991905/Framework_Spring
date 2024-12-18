package ru.example.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.hw.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
