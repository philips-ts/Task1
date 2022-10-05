package com.tarasenko.shop;

import com.tarasenko.shop.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Bucket {
    private final Map<Product, Integer> orders = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new RuntimeException("AddProduct parameter is null");
        }
        if (quantity < 1) {
            throw new RuntimeException("Quantity must be above 0");
        }

        Integer productCount = orders.get(product);
        if (productCount == null) {
            orders.put(product, 1);
        } else {
            productCount += quantity;
            orders.put(product, productCount);
        }
    }


    private Optional<Product> findProductById(int productId) {
        Product foundProduct = null;

        for (Map.Entry<Product, Integer> productEntry : orders.entrySet()) {
            if (productEntry.getKey().getId() == productId) {
                foundProduct = productEntry.getKey();
            }
        }

        return Optional.ofNullable(foundProduct);
    }

    public boolean removeProduct(int productId) {
        Optional<Product> foundProduct = findProductById(productId);
        if (foundProduct.isPresent()) {
            Integer productCount = orders.get(foundProduct.get());
            if (productCount > 1) {
                productCount--;
                orders.put(foundProduct.get(), productCount);
            } else {
                orders.remove(foundProduct.get());
            }

            return true;
        }

        return false;
    }

    public Map<Product, Integer> getBucket() {
        return new HashMap<>(orders);
    }


    public void clear() {
        orders.clear();
    }

    public int getNumberOfProducts() {
        return orders.size();
    }
}
