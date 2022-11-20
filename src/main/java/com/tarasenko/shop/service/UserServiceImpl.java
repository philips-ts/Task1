package com.tarasenko.shop.service;

import com.tarasenko.shop.dto.UserDto;
import com.tarasenko.shop.entity.User;
import com.tarasenko.shop.mapper.UserMapper;
import com.tarasenko.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<UserDto> getActiveUser() {
        User user = userRepository.getActiveUser();
        if (user == null) {
            return Optional.empty();
        }

        UserDto userDto= userMapper.toDto(user);

        return Optional.ofNullable(userDto);
    }
}
