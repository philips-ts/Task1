package com.tarasenko.shop.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {
    protected int productId;

    protected String name;

    protected LocalDate dateOfManufacture;

    protected int price;
}
