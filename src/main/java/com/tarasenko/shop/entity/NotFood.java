package com.tarasenko.shop.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "not_food")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class NotFood extends Product implements Serializable {
    @Column(name = "is_breakable")
    private boolean isBreakable;

    @Override
    public String toString() {
        return "NotFood: " +
                "isBreakable=" + isBreakable +
                ", dateOfManufacture=" + dateOfManufacture +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
