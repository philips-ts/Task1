package com.tarasenko.shop.service;

import com.tarasenko.shop.entity.BucketItem;
import com.tarasenko.shop.entity.OrderItem;
import com.tarasenko.shop.entity.Product;

import java.util.List;



public interface BucketService {
    void addProduct(Product productDto, int quantity);

    List<BucketItem> getBucketItems();

    void clear();

    int getTotalCost();
}
