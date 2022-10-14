package com.tarasenko.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class Product implements Serializable {
    @ExpireDate
    protected int expirationDate;
    protected LocalDate dateOfManufacture;

    protected String name;
    protected int price;
}
