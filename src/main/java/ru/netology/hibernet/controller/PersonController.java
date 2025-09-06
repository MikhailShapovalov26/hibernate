package ru.netology.hibernet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/by-city")
    public List<String> randomOrder(@RequestParam String city) {
        List<String> allPerson = new ArrayList<>();
        this.personService.getPersonsByCity(city).forEach(person ->
        {
            allPerson.add(person.getPersonName().getName());
        });
        return allPerson;
    }

    @PostMapping("/person/add")
    public String addPerson(@RequestBody Person person) {
        return this.personService.savePerson(person).getPersonName().getName();
    }
}
