package ru.netology.b9l4t1;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :cityName", Person.class);
        query.setParameter("cityName", city);
        return query.getResultList();
    }
}
