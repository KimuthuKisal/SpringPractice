package com.example.SpringDemo.api;

import com.example.SpringDemo.model.Person;
import com.example.SpringDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
