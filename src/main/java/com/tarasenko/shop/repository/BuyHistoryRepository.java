package com.tarasenko.shop.repository;

import com.tarasenko.shop.entity.Order;

import java.util.List;

public interface BuyHistoryRepository {
    List<Order> getOrdersByUserId(int userId);
}
