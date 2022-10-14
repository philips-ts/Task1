package com.tarasenko.shop.bucket;

import com.tarasenko.shop.model.OrderItem;
import com.tarasenko.shop.model.Product;

import java.util.List;

public interface Bucket {
    void addProduct(Product product, int quantity);

    boolean removeProductByName(String productName);

    List<OrderItem> getOrderItems();

    void clear();

    int getTotalCost();

    boolean save(String fileName);

    @SuppressWarnings("unchecked")
    boolean load(String fileName);
}
