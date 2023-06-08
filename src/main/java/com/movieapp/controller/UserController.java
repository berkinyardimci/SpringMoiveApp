package com.movieapp.controller;

import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserFindAllResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.User;
import com.movieapp.entity.UserType;
import com.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //register metotu yazalım parametre olarak UserRegisterDto alsın
    //kullanıcı register olurken name surname email password versin
    //UserRegisterDto Oluşturalım
    //bize User dönsün

    //id, name, surname, email, userType
    //UserRegisterResponseDto
    //PostMapping

    //findAll --> UserFindAllResponseDto
    //id, name, email, surname, phone, usertype, favMovies, genres

    private final UserService userService;

    @PostMapping("/register")
    public UserRegisterResponseDto createUser(UserRegisterRequestDto dto){
        return userService.register(dto);
    }

    @GetMapping("/create")
    public User createUser(String name, String surname, String email, String phone, String password, String userType){
        return userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findalldto")
    public List<UserFindAllResponseDto> findAlldto(){
        return userService.findAlldto();
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
    //Restful api Naming convension best practice
    @GetMapping("/endingwith")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> existsByEmailAndPassword(String email, String password){
        return ResponseEntity.ok(userService.existsByEmailAndPassword(email,password));
    }

    @GetMapping("/login2")
    public ResponseEntity<Optional<User>> findByEmailIgnoreCaseAndPassword(String email, String password){
        return ResponseEntity.ok(userService.findByEmailIgnoreCaseAndPassword(email,password));
    }

    @GetMapping("/passwordcheck")
    public ResponseEntity<List<User>> passwordLongerThan(int length){
        return ResponseEntity.ok(userService.passwordLongerThan(length));
    }


}
