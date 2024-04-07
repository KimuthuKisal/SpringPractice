package com.example.SpringDemo.service;

import com.example.SpringDemo.dao.PersonDao;
import com.example.SpringDemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        System.out.println("PersonService - PersonService : " + personDao);
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        System.out.println("PersonService - addPerson : " + person.getName());
        return personDao.insertPerson(person);
    }
}
