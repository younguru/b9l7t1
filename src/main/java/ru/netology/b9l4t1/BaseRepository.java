package ru.netology.b9l4t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BaseRepository {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> getPersonsByAge(Integer age) {
        return personRepository.findByHumanAgeLessThanOrderByHumanAge(age);
    }

    public Optional<List<Person>> getPersonsByNS(String name, String surname) {
        return personRepository.findByHumanNameAndHumanSurname(name, surname);
    }
}
