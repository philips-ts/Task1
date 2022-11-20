package com.tarasenko.shop.mapper;

import com.tarasenko.shop.dto.UserDto;
import com.tarasenko.shop.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
