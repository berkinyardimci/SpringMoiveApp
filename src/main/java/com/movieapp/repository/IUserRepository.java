package com.movieapp.repository;

import com.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    //1
    List<User> findAllByOrderByName();
    //2
    List<User> findAllByNameLike(String name);
    //3
    List<User> findUsersByEmailContainingIgnoreCase(String value);
    List<User> findAllByEmailContainingIgnoreCase(String value);
    //4
    List<User> findAllByEmailEndsWith(String value);
    List<User> findAllByEmailEndingWith(String value);
    List<User> findAllByEmailStartingWith(String value);
}
