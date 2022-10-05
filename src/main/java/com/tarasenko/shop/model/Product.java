package com.tarasenko.shop.model;

import lombok.Data;


@Data
public class Product {
    protected int id;
    protected String name;
    protected int price;
}
