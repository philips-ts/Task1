package com.tarasenko.shop.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "food")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Food extends Product implements Serializable {
    @Column(name = "max_storage_temperature")
    private short maxStorageTemperature;

    @Column(name = "shelf_life_months")
    private int shelfLifeMonths;

    @Override
    public String toString() {
        return "Food: " +
                "maxStorageTemperature=" + maxStorageTemperature +
                ", shelf life=" + shelfLifeMonths +
                ", dateOfManufacture=" + dateOfManufacture +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
