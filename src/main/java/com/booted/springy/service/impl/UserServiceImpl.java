package com.booted.springy.service.impl;

import com.booted.springy.dto.UserDto;
import com.booted.springy.entity.User;
import com.booted.springy.exceptions.ResourceNotFoundException;
import com.booted.springy.mapper.UserMapper;
import com.booted.springy.respository.UserRespository;
import com.booted.springy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRespository userRespository;

    @Autowired
    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        User user= UserMapper.mapToUser(userDto);
        User createdUser=userRespository.save(user);
        return UserMapper.mapToUserDto(createdUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user=userRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User with that ID doesn't exist"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRespository.findAll();
        return users.stream().map((user)->UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUserById(Long id, UserDto userDto) {
        User user=userRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User with that ID doesn't exist"));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        User updatedUser=userRespository.save(user);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public String deleteUserById(Long id) {
        User user=userRespository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User with that ID doesn't exist"));
        userRespository.deleteById(id);
        return "User deleted successfully";
    }

}
