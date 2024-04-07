package com.example.SpringDemo.dao;

import com.example.SpringDemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personToBeDeleted = getPersonById(id);
        if ( personToBeDeleted.isPresent() ) {
            DB.remove(personToBeDeleted.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return getPersonById(id).map( p-> {
            int indexToBeUpdated = DB.indexOf(p);
            if ( indexToBeUpdated >= 0 ) {
                DB.set(indexToBeUpdated, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream().filter(person->person.getId().equals(id)).findFirst();
    }
}
