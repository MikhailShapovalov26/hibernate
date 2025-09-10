package ru.netology.hibernet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return this.personService.findByCityOfLiving(city);
    }
    @GetMapping("/person/less-age")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return personService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/person/name-surname")
    public Optional<Person> getPersonsByNameSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getPersonsByNameSurname(name, surname);
    }

    @PostMapping("/person/add")
    public String addPerson(@RequestBody Person person) {
        return this.personService.savePerson(person).getPersonName().getName();
    }
}
