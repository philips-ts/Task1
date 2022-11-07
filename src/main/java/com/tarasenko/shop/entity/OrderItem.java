package com.tarasenko.shop.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class OrderItem implements Serializable {
    private Product product;
    private int quantity;

    @Override
    public String toString() {
        return "OrderItem :" +
                "product = " + product +
                ", quantity=" + quantity ;
    }
}
