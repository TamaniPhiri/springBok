package com.booted.springy.service;

import com.booted.springy.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
}
