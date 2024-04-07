package com.example.SpringDemo.api;

import com.example.SpringDemo.model.Person;
import com.example.SpringDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        System.out.println("PersonController - PersonController : " + personService);
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        System.out.println("PersonController - addPerson : " + person.getName());
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person selectPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int removePerson(@PathVariable("id") UUID id) {
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.updatePersonById(id, person);
    }
}
