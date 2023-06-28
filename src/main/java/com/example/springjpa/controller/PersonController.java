package com.example.springjpa.controller;

import com.example.springjpa.dto.DetailsPerson;
import com.example.springjpa.dto.FullNamePerson;
import com.example.springjpa.entitiy.Person;
import com.example.springjpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public FullNamePerson getPersonById(@PathVariable long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable long id) {
        return personService.deletePerson(id);
    }

    @GetMapping()
    public List<FullNamePerson> getPersonList() {
        return personService.getPersonList();
    }

    @GetMapping("/details")
    public List<DetailsPerson> getPersonListDetail() {
        return personService.getPersonListDetail();
    }
}
