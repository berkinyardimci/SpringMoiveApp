package com.movieapp.controller;

import com.movieapp.entity.User;
import com.movieapp.entity.UserType;
import com.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //10:25
    private final UserService userService;

    @GetMapping("/create")
    public User createUser(String name, String surname, String email, String phone, String password, String userType){
        return userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findall")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/orderbyname")
    public ResponseEntity<List<User>> findAllByOrderByName(){
        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/namelike")
    public ResponseEntity<List<User>> findAllByNameLike(String name){
        return ResponseEntity.ok(userService.findAllByNameLike("%"+name+"%"));
    }

    @GetMapping("/containingemail")
    public ResponseEntity<List<User>> findUsersByEmailContainingIgnoreCase(String value){
        return ResponseEntity.ok(userService.findUsersByEmailContainingIgnoreCase(value));
    }

    @GetMapping("/endswith")
    public ResponseEntity<List<User>> findAllByEmailEndsWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndsWith(value));
    }
    //Rest Best Practice
    //Restful api Naming convencion best practice
    @GetMapping("/endingwith")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }

}
