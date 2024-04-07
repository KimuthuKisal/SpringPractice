package com.example.SpringDemo.dao;

import com.example.SpringDemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        System.out.println("FakePersonDataAccessService - insertPerson : " + id + " " + person.getName());
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
