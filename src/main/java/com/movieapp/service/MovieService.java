package com.movieapp.service;

import com.movieapp.entity.Movie;
import com.movieapp.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie findbyId(long id) {
       Optional<Movie> optionalMovie =  movieRepository.findById(id);
       if(optionalMovie.isPresent()){
           return optionalMovie.get();
       }else{
           throw new RuntimeException("Film bulunamadi");
       }
    }

    public List<Movie> findAllByIds(List<Long> ids) {
        return ids.stream().map(x-> movieRepository.findById(x).get()).collect(Collectors.toList());
    }

    public List<Movie> findAllByIds2(List<Long> ids) {
        return movieRepository.findAllById(ids);
    }
}
