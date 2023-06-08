package com.movieapp.controller;

import com.movieapp.entity.Movie;
import com.movieapp.entity.User;
import com.movieapp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/greaterthan")
    public ResponseEntity<List<Movie>> findAllByRatingGreaterThan(double rate){
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(rate));
    }

    @GetMapping("/findmoviesbygenres")
    public ResponseEntity<List<Movie>> findMoviesByUserGenres(Long id){
        return ResponseEntity.ok(movieService.findMoviesByUserGenres(id));
    }

    @GetMapping("/findbeforedate")
    public ResponseEntity<List<Movie>> findAllByPremieredBefore(LocalDate date){
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }

    @GetMapping("/searchrating")
    public ResponseEntity<Object[]> searchByRating(double rate){
        return ResponseEntity.ok(movieService.searchByRating(rate));
    }

    @GetMapping("/searchrating2")
    public ResponseEntity<List<Object>> searchByRating(){
        return ResponseEntity.ok(movieService.searchByRating2());
    }

    @GetMapping("/searchrating789")
    public ResponseEntity<List<Movie>> findAllByRatingIn(){
        return ResponseEntity.ok(movieService.findAllByRatingIn());
    }
    @GetMapping("/searchbyname")
    public ResponseEntity<List<Movie>> findAllByRatingIn(String[] names){
        return ResponseEntity.ok(movieService.findAllByRatingIn(names));
    }

}
