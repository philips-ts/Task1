package com.tarasenko.shop.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class FoodDto extends ProductDto {
    private short maxStorageTemperature;
    private int shelfLifeMonths;
}
