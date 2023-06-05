package com.movieapp.service;

import com.movieapp.entity.Movie;
import com.movieapp.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }
}
