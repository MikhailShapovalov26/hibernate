package ru.netology.hibernet.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
    public Person savePerson(Person person) {
        return repository.save(person);
    }
}
