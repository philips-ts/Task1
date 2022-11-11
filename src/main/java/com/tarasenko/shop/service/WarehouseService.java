package com.tarasenko.shop.service;

import com.tarasenko.shop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    Optional<Product> findProductByName(String productName);
    Optional<Product> findProductById(int id);
    List<Product> getAllProducts();
}
