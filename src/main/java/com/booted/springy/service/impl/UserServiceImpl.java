package com.booted.springy.service.impl;
import com.booted.springy.dto.UserDto;
import com.booted.springy.entity.User;
import com.booted.springy.mapper.UserMapper;
import com.booted.springy.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private UserService userService;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user= UserMapper.mapToUser(userDto);
        return null;
    }
}
