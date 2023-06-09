package com.movieapp.dto.response;

import com.movieapp.entity.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLoginResponseDto {

    private Long id;
    private String name;
    private String email;
    private UserType userType;
}
