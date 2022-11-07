package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public User getUserById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> users = entityManager.createQuery("select u from User u")
                .getResultList();

        entityManager.close();

        return users;
    }

    @Override
    public void addUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUserById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
