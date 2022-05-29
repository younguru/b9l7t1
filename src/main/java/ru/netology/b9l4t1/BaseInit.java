package ru.netology.b9l4t1;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class BaseInit {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void run() {
        var names = List.of("Nurlan", "Tambi", "Ilya", "Rustam", "Alexey");
        var surnames = List.of("Saburov", "Masaev", "Makarov", "Reptiloid", "Sherbakov");
        var cities = List.of("Moscow", "Kazan", "Tomsk", "Ekaterinburg");
        var random = new Random();
        IntStream.range(0, 10).forEach(i -> {
            Person person = Person.builder()
//                    .id(i)
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

}
