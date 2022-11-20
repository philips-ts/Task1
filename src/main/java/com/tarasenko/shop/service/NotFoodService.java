package com.tarasenko.shop.service;

import com.tarasenko.shop.dto.NotFoodDto;

import java.util.List;

public interface NotFoodService {
    void addNotFood(NotFoodDto notFoodDto);
    List<NotFoodDto> getAllNotFood();
    void removeNotFood(int id);
}
