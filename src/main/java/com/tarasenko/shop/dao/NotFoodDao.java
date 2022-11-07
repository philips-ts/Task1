package com.tarasenko.shop.dao;

import com.tarasenko.shop.entity.NotFood;

import java.util.List;

public interface NotFoodDao {
    NotFood getById(int id);

    List<NotFood> getAll();

    void add(NotFood notFood);

    void deleteById(int id);
}
