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

    @Query("SELECT p FROM Person p where p.cityOfLiving = :city")
    List<Person> CityOfLiving(String city);

    @Query("SELECT p FROM Person p where p.personName.age < :age order by p.personName.age")
    List<Person> PersonNameAgeLessThan(int age);

    @Query("SELECT p FROM Person p where p.personName.name = :name and p.personName.surname = :surname" )
    Optional<Person> PersonNameNameAndPersonNameSurname(String name, String surname);


}
