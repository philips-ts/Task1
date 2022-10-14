package com.tarasenko.shop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Food extends Product implements Serializable {
    private short maxStorageTemperature;

    @Override
    public String toString() {
        return "Food: " +
                "maxStorageTemperature=" + maxStorageTemperature +
                ", expirationDate=" + expirationDate +
                ", dateOfManufacture=" + dateOfManufacture +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
