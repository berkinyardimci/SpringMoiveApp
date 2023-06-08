package com.movieapp.repository;

import com.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    Boolean existsByEmailAndPassword(String email, String password);

    Optional<User> findByEmailIgnoreCaseAndPassword(String email, String password);

    @Query("select u from User u where length(u.password) >:x")
    List<User> passwordLongerThan(@Param("x") int length);
    /*
    @Query("select u from User u where length(u.password) >:x and length(u.surname) <:y")
    List<User> passwordLongerThan(@Param("y") int bisey,@Param("x") int length );
     */
    @Query(value = "select * from tbl_user  where length(password)>?1", nativeQuery = true)
    List<User> passwordLongerThanNative(int length);
    /*
    @Query(value = "select * from tbl_user  where length(password)>?1 and name=?2", nativeQuery = true)
    List<User> passwordLongerThanNative2(int length , String name);
     */
}
