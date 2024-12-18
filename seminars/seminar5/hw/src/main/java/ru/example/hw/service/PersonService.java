package ru.example.hw.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.hw.model.Person;
import ru.example.hw.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(personDetails.getName());
            person.setAge(personDetails.getAge());
            person.setEmail(personDetails.getEmail());
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Person is not found with id: " + id);
        }
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
