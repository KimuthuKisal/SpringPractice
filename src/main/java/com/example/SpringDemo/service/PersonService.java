package com.example.SpringDemo.service;

import com.example.SpringDemo.dao.PersonDao;
import com.example.SpringDemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return personDao.selectAllPerson();
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public Optional<Person> getPersonById(UUID id) {
        return  personDao.getPersonById((id));
    }

    public int updatePersonById(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }

}
