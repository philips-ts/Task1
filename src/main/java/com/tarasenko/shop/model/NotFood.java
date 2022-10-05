package com.tarasenko.shop.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class NotFood extends Product{
    private LocalDate dateOfManufacture;

    @Override
    public String toString() {
        return "NotFood: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", price=" + price;
    }
}
