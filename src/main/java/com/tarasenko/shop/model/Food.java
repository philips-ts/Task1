package com.tarasenko.shop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Food extends Product{
    private LocalDate expirationDate;
    private short maxStorageTemperature;

    @Override
    public String toString() {
        return "Food: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", maxStorageTemperature=" + maxStorageTemperature +
                ", price=" + price;
    }
}
