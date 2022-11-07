package com.tarasenko.shop.service;

import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.Product;

import java.util.List;



public interface BucketService {
    void addProduct(Product product, int quantity);

    boolean removeProductById(int id);

    boolean removeProductByName(String productName);

    List<OrderItem> getOrderItems();

    void clear();

    int getTotalCost();
}
