package ru.netology.hibernet.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.netology.hibernet.model.Person;
import ru.netology.hibernet.model.PersonName;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, PersonName> {

    @Query(value = "SELECT * FROM PERSONS WHERE city_of_living = :city", nativeQuery = true)
    List<Person> getPersonsByCity(String city);

}
