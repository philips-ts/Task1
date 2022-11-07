package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


@Repository
public class BuyHistoryDaoImpl implements BuyHistoryDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getOrdersByUserId(int userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("buy_history", Order.class)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .setParameter(1, userId);

        List<Order> buyHistory = (List<Order>)query.getResultList();

        buyHistory.forEach(System.out::println);

        return buyHistory;
    }
}

