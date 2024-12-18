package ru.example.hw.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.hw.model.Person;
import ru.example.hw.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
//@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/findById/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping("/del/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        System.out.printf("Person by id: %d has been deleted\n", id);
    }

    @PostMapping("/change/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails){
        return personService.updatePerson(id, personDetails);
    }

}
