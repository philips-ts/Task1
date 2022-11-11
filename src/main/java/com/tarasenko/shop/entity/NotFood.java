package com.tarasenko.shop.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "not_food")
@Data
@EqualsAndHashCode(callSuper = true)
public class NotFood extends Product implements Serializable  {
    @Column(name = "is_breakable")
    private boolean isBreakable;
}
