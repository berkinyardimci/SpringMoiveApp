package com.movieapp.dto.response;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.entity.MovieComment;
import com.movieapp.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserFindAllResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private UserType userType;
    private List<Genre> favGenres;
    private List<String> movieCommentsContent;
    private Map<String ,String> movieContent;

}
