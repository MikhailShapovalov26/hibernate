package ru.netology.hibernet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return this.personService.findByCityOfLiving(city);
    }
    @GetMapping("less-age")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return personService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("name-surname")
    public Optional<Person> getPersonsByNameSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getPersonsByNameSurname(name, surname);
    }
    @GetMapping("/all")
    public List<Person> getAllPerson() {
        return personService.allPerson();
    }
}
