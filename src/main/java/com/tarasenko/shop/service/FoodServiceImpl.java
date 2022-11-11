package com.tarasenko.shop.service;

import com.tarasenko.shop.repository.FoodRepository;
import com.tarasenko.shop.dto.FoodDto;
import com.tarasenko.shop.entity.Food;
import com.tarasenko.shop.mapper.FoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    @Override
    public void addFood(FoodDto foodDto) {
        Food food = foodMapper.toEntity(foodDto);
        foodRepository.save(food);
    }

    @Override
    public List<FoodDto> getAllFood() {
        List<Food> allFood = foodRepository.findAll();

        return foodMapper.toDto(allFood);
    }

    @Override
    public void removeFood(int id) {
        foodRepository.deleteById(id);
    }
}
