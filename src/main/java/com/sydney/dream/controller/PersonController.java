package com.sydney.dream.controller;

import com.sydney.dream.entity.Person;
import com.sydney.dream.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonController implements Serializable{

    @Autowired
    private PersonService service;

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    private List<Person> getAllPerson() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person createPerson(@Valid @RequestBody Person person) {
        return service.savePerson(person);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> findOne(@PathVariable("id") Long id) {
        Person person = service.findOne(id);
        if (person == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updateTodo(@Valid @RequestBody Person person, @PathVariable("id") Long id) {
        Person personUpdate = service.findOne(id);
        if (personUpdate == null) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        personUpdate.setName(person.getName());
        personUpdate.setAddress(person.getAddress());
        return new ResponseEntity<Person>(personUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
