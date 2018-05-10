package com.sydney.dream.service;

import com.sydney.dream.entity.Person;
import com.sydney.dream.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    
    
    @Autowired
    private PersonRepository personRepository;
    
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findOne(long id) {
        return personRepository.getOne(id);
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
    
}
