package com.tarasenko.shop.mapper;

import com.tarasenko.shop.dto.NotFoodDto;
import com.tarasenko.shop.entity.NotFood;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface NotFoodMapper {
    NotFoodDto toDto(NotFood notFood);
    NotFood toEntity(NotFoodDto notFoodDto);

    List<NotFoodDto> toDto(List<NotFood> notFoodList);
    List<NotFood> toEntity(List<NotFoodDto> foodDtoList);
}
