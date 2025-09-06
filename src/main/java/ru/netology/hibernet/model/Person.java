package ru.netology.hibernet.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "PERSONS")
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @EmbeddedId
    private PersonName personName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;
}
