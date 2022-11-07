package com.tarasenko.shop.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotFoodDto {
    private int id;
    private String name;
    private LocalDate dateOfManufacture;
    private int price;
    private boolean isBreakable;
}
