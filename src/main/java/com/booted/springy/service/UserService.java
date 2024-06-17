package com.booted.springy.service;

import com.booted.springy.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUserById(Long userId,UserDto userDto);
    UserDto deleteUserById(Long id);
}
