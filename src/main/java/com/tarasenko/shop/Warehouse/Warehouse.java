package com.tarasenko.shop.Warehouse;

import com.tarasenko.shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface Warehouse {
    Optional<Product> getProductByName(String productName);
    List<Product> getProducts();

    void addProduct(Product product);

    boolean removeProductByName(String productName);

    boolean save(String fileName);

    boolean load(String fileName);
}
