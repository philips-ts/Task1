package com.tarasenko.shop.repository;

import com.tarasenko.shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
