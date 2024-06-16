package com.booted.springy.controller;

import com.booted.springy.dto.UserDto;
import com.booted.springy.entity.User;
import com.booted.springy.service.MailService;
import com.booted.springy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private MailService mailService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser=userService.createUser(userDto);
        mailService.sendMail(createdUser.getEmail(),"Account Creation","Thanks and welcome");
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
