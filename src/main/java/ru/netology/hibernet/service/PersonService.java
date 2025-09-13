package ru.netology.hibernet.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    public List<Person> findByCityOfLiving(String city) {
        return repository.CityOfLiving(city);
    }
    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return repository.PersonNameAgeLessThan(
                age);
    }

    public Optional<Person> getPersonsByNameSurname(String name, String surname) {
        return repository.PersonNameNameAndPersonNameSurname(name, surname);
    }

    public List<Person> allPerson() {
        return repository.allPerson();
    }
}
