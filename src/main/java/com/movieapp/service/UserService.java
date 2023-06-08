package com.movieapp.service;

import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserFindAllResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.User;
import com.movieapp.entity.UserType;
import com.movieapp.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(String name, String surname, String email, String phone, String password, String userType) {
        UserType userType1 = null;
        User user;
        try {
            userType1 = UserType.valueOf(userType);
            user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .userType(userType1)
                    .build();
        }catch (Exception ex){
            System.out.println("Böyle bir userType bulunamadı");
            user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .build();
        }
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser;
        }else {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public List<User> findAllByOrderByName() {
        List<User> userList = userRepository.findAllByOrderByName();
        if(userList.size() > 0){
            return userList;
        }else {
            throw new RuntimeException("Veri Yok");
        }
    }
    public List<User> findAllByNameLike(String name) {
        return userRepository.findAllByNameLike(name);
    }

    public List<User> findUsersByEmailContainingIgnoreCase(String value) {
        return userRepository.findUsersByEmailContainingIgnoreCase(value);
    }

    public List<User> findAllByEmailEndsWith(String value) {
        return userRepository.findAllByEmailEndsWith(value);
    }

    public List<User> findAllByEmailEndingWith(String value) {
        return userRepository.findAllByEmailEndingWith(value);
    }

    public Boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email,password);
    }

    public Optional<User> findByEmailIgnoreCaseAndPassword(String email, String password) {
        Optional<User> optionalUser =  userRepository.findByEmailIgnoreCaseAndPassword(email,password);
        if(optionalUser.isPresent()){
            return optionalUser;
        }else {
            throw new RuntimeException("Böyle bir kullanıcı yok");
        }
    }

    public List<User> passwordLongerThan(int length) {
        return userRepository.passwordLongerThan(length);
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto dto){
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        userRepository.save(user);

        return UserRegisterResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .userType(user.getUserType())
                .genres(user.getFavGenres())
                .build();
    }

    public List<UserFindAllResponseDto> findAlldto() {
        return userRepository.findAll().stream().map(x->{
            return UserFindAllResponseDto.builder()
                    .id(x.getId())
                    .name(x.getName())
                    .surname(x.getSurname())
                    .favGenres(x.getFavGenres())
                    .favMovie(x.getFavMovies())
                    .phone(x.getPhone())
                    .userType(x.getUserType())
                    .build();
        }).collect(Collectors.toList());
    }
}
