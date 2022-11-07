package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.Food;

import java.util.List;

public interface FoodDao {
    Food getById(int id);

    List<Food> getAll();

    void add(Food food);

    void deleteById(int id);
}
