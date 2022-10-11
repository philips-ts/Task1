package com.tarasenko.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class OrderItem implements Serializable {
    private Product product;
    private int amount;

    @Override
    public String toString() {
        return "OrderItem :" +
                "product = " + product +
                ", amount=" + amount ;
    }
}

