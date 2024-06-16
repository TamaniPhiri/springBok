package com.booted.springy.mapper;

import com.booted.springy.dto.UserDto;
import com.booted.springy.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return  new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static User mapToUser
}
