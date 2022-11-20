package com.tarasenko.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    protected int productId;

    @Column(name = "name", length = 20)
    protected String name;

    @Column(name = "manufacture_date")
    protected LocalDate dateOfManufacture;

    @Column(name = "price")
    protected int price;
}
