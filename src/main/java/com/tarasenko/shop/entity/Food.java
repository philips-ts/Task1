package com.tarasenko.shop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "food")
@Data
@EqualsAndHashCode(callSuper = true)
public class Food extends Product implements Serializable {
    @Column(name = "max_storage_temperature")
    private short maxStorageTemperature;

    @Column(name = "shelf_life_months")
    private int shelfLifeMonths;
}
