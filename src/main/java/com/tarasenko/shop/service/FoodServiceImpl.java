package com.tarasenko.shop.service;

import com.tarasenko.shop.dao.FoodDao;
import com.tarasenko.shop.dto.FoodDto;
import com.tarasenko.shop.entity.Food;
import com.tarasenko.shop.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodDao foodDao;
    private final FoodMapper foodMapper;

    @Autowired
    public FoodServiceImpl(FoodDao foodDao, FoodMapper foodMapper) {
        this.foodDao = foodDao;
        this.foodMapper = foodMapper;
    }

    @Override
    public void addFood(FoodDto foodDto) {
        Food food = foodMapper.toEntity(foodDto);
        foodDao.add(food);
    }

    @Override
    public List<FoodDto> getAllFood() {
        List<Food> allFood = foodDao.getAll();
        List<FoodDto> foodDtos = foodMapper.toDto(allFood);

        return foodDtos;
    }

    @Override
    public void removeFood(int id) {
        foodDao.deleteById(id);
    }
}
