package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FoodDaoImpl implements FoodDao {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public FoodDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Food getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Food food = entityManager.find(Food.class, id);
        entityManager.close();

        return food;
    }

    @Override
    public List<Food> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Food> query = entityManager.createQuery("select fd from Food fd", Food.class);

        return query.getResultList();
    }

    @Override
    public void add(Food food) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(food);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Food food = entityManager.find(Food.class, id);
        if (food != null) {
            entityManager.getTransaction().begin();

            entityManager.remove(food);

            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
