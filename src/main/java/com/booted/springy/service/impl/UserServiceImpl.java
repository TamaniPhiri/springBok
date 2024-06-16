package com.booted.springy.service.impl;

import com.booted.springy.dto.UserDto;
import com.booted.springy.entity.User;
import com.booted.springy.mapper.UserMapper;
import com.booted.springy.respository.UserRespository;
import com.booted.springy.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private UserRespository userRespository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user= UserMapper.mapToUser(userDto);
        User createdUser=userRespository.save(user);
        return UserMapper.mapToUserDto(createdUser);
    }
}
