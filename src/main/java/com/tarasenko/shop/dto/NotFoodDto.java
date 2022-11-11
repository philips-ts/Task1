package com.tarasenko.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class NotFoodDto extends ProductDto {
    private boolean isBreakable;
}
