package com.tarasenko.shop.dto;


import lombok.Data;

import java.time.LocalDate;


@Data
public class FoodDto {
    private int id;
    private String name;
    private LocalDate dateOfManufacture;
    private int price;
    private short maxStorageTemperature;
    private int shelfLifeMonths;
}
