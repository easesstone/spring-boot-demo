package com.sydney.dream.service;

import com.sydney.dream.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> findAll();

    public Person savePerson(Person person);

    public Person findOne(long id);

    public void delete(long id);
}
