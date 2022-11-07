package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.Order;

import java.util.List;

public interface BuyHistoryDao {
    List<Order> getOrdersByUserId(int userId);
}
