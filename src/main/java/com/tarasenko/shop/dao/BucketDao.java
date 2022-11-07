package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.Product;

import java.util.List;

public interface BucketDao {
    void addProduct(Product product, int quantity);

    boolean removeProductByName(String productName);

    boolean removeProductById(int id);

    List<OrderItem> getOrderItems();

    void clear();
}
