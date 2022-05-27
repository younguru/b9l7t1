package ru.netology.b9l4t1;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Repository
public class BaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    void init() {
        var names = List.of("Nurlan", "Tambi", "Ilya", "Rustam", "Alexey");
        var surnames = List.of("Saburov", "Masaev", "Makarov", "Reptiloid", "Sherbakov");
        var cities = List.of("Moscow", "Kazan", "Tomsk", "Ekaterinburg");
        var random = new Random();
        IntStream.range(0, 5).forEach(i -> {
            Person person = Person.builder()
                    .id(0)
                    .human(Human.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(40)).build())
                    .phoneNumber("+7(960) 960-00-0" + i)
                    .city(cities.get(random.nextInt(cities.size())))
                    .build();
            entityManager.persist(person);
        });
    }

    @Transactional
    public Person getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :cityName", Person.class);
        return null;
    }
}
