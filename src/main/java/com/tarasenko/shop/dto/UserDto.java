package com.tarasenko.shop.dto;

import lombok.Data;

@Data
public class UserDto {
    private int userId;

    private String name;

    private boolean isActive;
}
