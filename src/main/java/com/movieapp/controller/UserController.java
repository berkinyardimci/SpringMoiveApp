package com.movieapp.controller;

import com.movieapp.entity.User;
import com.movieapp.entity.UserType;
import com.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public User createUser(String name, String surname, String email, String phone, String password, String userType){
        return userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findall")
    public List<User> createUser(){
        return userService.findAll();
    }
}
