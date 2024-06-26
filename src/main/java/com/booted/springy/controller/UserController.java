package com.booted.springy.controller;

import com.booted.springy.dto.UserDto;
import com.booted.springy.service.MailService;
import com.booted.springy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private MailService mailService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
           UserDto createdUser=userService.createUser(userDto);
           String emailStatus=mailService.sendMail(createdUser.getEmail(),"Account Creation","Thanks and welcome");
           System.out.println(emailStatus);
           return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto user=userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable("id") Long id,@RequestBody UserDto userDto){
        UserDto user=userService.updateUserById(id,userDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        String status= userService.deleteUserById(id);
        return ResponseEntity.ok(status);
    }
}
