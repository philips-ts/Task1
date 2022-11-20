package com.tarasenko.shop.service;

import com.tarasenko.shop.dto.UserDto;

import java.util.Optional;

public interface UserService {
    Optional<UserDto> getActiveUser();
}
