package com.tarasenko.shop.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class NotFood extends Product implements Serializable {
    private boolean isBreakable;

    @Override
    public String toString() {
        return "NotFood: " +
                "isBreakable=" + isBreakable +
                ", expirationDate=" + expirationDate +
                ", dateOfManufacture=" + dateOfManufacture +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}

