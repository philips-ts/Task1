package com.tarasenko.shop.service;

import com.tarasenko.shop.dto.FoodDto;

import java.util.List;

public interface FoodService {
    void addFood(FoodDto foodDto);

    List<FoodDto> getAllFood();

    void removeFood(int id);
}
