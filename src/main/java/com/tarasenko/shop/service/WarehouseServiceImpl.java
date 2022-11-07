package com.tarasenko.shop.service;

import com.tarasenko.shop.dao.FoodDao;
import com.tarasenko.shop.dao.NotFoodDao;
import com.tarasenko.shop.entity.Food;
import com.tarasenko.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final FoodDao foodDao;
    private final NotFoodDao notFoodDao;


    @Autowired
    public WarehouseServiceImpl(FoodDao foodDao, NotFoodDao notFoodDao) {
        this.foodDao = foodDao;
        this.notFoodDao = notFoodDao;
    }

    @Override
    public Optional<Product> findProductByName(String productName) {
        return getAllProducts().stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .map(Optional::of)
                .findFirst()
                .orElseGet(Optional::empty);
    }

    @Override
    public Optional<Product> findProductById(int id) {
        return getAllProducts().stream()
                .filter(product -> product.getId() == id)
                .map(Optional::of)
                .findFirst()
                .orElseGet(Optional::empty);
    }

    @Override
    public List<Product> getAllProducts() {
        final List<Product> products = new ArrayList<>();
        products.addAll(foodDao.getAll());
        products.addAll(notFoodDao.getAll());

        return products;
    }
}
