package ru.netology.hibernet.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.model.PersonName;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, PersonName> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByPersonNameAgeLessThan(int age, Sort sort);

    Optional<Person> findByPersonNameNameAndPersonNameSurname(String name, String surname);


}
