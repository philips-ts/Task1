package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.NotFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NotFoodDaoImpl implements NotFoodDao {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public NotFoodDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public NotFood getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        NotFood notFood = entityManager.find(NotFood.class, id);
        entityManager.close();

        return notFood;
    }

    @Override
    public List<NotFood> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<NotFood> query = entityManager.createQuery("select nfd from NotFood nfd", NotFood.class);

        return query.getResultList();
    }

    @Override
    public void add(NotFood notFood) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(notFood);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        NotFood notFood = entityManager.find(NotFood.class, id);
        if (notFood != null) {
            entityManager.getTransaction().begin();

            entityManager.remove(notFood);

            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
