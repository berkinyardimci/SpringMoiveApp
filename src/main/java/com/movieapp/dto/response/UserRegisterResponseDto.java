package com.movieapp.dto.response;

import com.movieapp.entity.Genre;
import com.movieapp.entity.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private UserType userType;
    private List<Genre> genres;
}
