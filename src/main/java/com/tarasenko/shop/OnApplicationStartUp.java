package com.tarasenko.shop;

import com.tarasenko.shop.entity.Food;
import com.tarasenko.shop.entity.NotFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class OnApplicationStartUp {
    private final EntityManagerFactory entityManagerFactory;


    @Autowired
    public OnApplicationStartUp(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initializeDatabaseWithTestData();
    }

    private void initializeDatabaseWithTestData() {
        EntityManager entityManager = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();

            ShopInitialization shopInitialization = new ShopInitialization();
            List<Food> foodList = shopInitialization.getTestFoodData();
            List<NotFood> notFoodList = shopInitialization.getTestNotFoodData();

            entityManager.getTransaction().begin();
            for (NotFood notFood : notFoodList) {
                entityManager.persist(notFood);
            }
            entityManager.getTransaction().commit();


            entityManager.getTransaction().begin();
            for (Food food : foodList) {
                entityManager.persist(food);
            }
            entityManager.getTransaction().commit();
        }
        finally {
            if (entityManager == null) {
                entityManager.close();
            }
        }
    }
}
