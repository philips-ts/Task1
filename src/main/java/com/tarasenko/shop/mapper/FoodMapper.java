package com.tarasenko.shop.mapper;

import com.tarasenko.shop.dto.FoodDto;
import com.tarasenko.shop.entity.Food;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodDto toDto(Food food);
    Food toEntity(FoodDto foodDto);

    List<FoodDto> toDto(List<Food> food);
    List<Food> toEntity(List<FoodDto> foodDto);
}
