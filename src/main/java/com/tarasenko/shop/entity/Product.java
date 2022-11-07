package com.tarasenko.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product implements Serializable {
    @Id
    @TableGenerator(
            name="product_id_generator",
            table="PRODUCT_ID_GENERATOR_TABLE",
            pkColumnName = "id",
            valueColumnName = "next_val",
            pkColumnValue="product",
            allocationSize = 10
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "product_id_generator")
    @Column(name = "id")
    protected int id;

    @Column(name = "name", length = 20)
    protected String name;

    @Column(name = "manufacture_date")
    protected LocalDate dateOfManufacture;

    @Column(name = "price")
    protected int price;
}
