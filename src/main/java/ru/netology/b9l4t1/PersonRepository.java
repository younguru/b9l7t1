package ru.netology.b9l4t1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Human> {
    List<Person> findByCity(String city);

    List<Person> findByHumanAgeLessThanOrderByHumanAge(Integer age);

    Optional<List<Person>> findByHumanNameAndHumanSurname(String name, String surname);
}
