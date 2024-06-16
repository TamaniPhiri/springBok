package com.booted.springy.controller;

import com.booted.springy.dto.UserDto;
import com.booted.springy.entity.User;
import com.booted.springy.service.MailService;
import com.booted.springy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private MailService mailService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        if (userDto == null || userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
       try {
           UserDto createdUser=userService.createUser(userDto);
           String emailStatus=mailService.sendMail(createdUser.getEmail(),"Account Creation","Thanks and welcome");
           System.out.println(emailStatus);
           return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
