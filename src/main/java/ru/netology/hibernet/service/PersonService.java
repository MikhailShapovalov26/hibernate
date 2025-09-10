package ru.netology.hibernet.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repository;
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    public List<Person> findByCityOfLiving(String city) {
        return repository.findByCityOfLiving(city);
    }
    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return repository.findByPersonNameAgeLessThan(
                age,
                Sort.by(Sort.Direction.ASC,
                "personNameAge"));
    }

    public Optional<Person> getPersonsByNameSurname(String name, String surname) {
        return repository.findByPersonNameNameAndPersonNameSurname(name, surname);
    }
}
