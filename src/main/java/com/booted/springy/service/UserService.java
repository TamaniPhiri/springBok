package com.booted.springy.service;

import com.booted.springy.dto.UserDto;

import java.util.Set;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    Set<UserDto> getAllUsers();
}
