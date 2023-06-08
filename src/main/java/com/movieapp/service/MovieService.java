package com.movieapp.service;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.entity.User;
import com.movieapp.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;
    private final UserService userService;

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

    public List<Movie> findAllByRatingGreaterThan(double rate) {
        return movieRepository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findMoviesByUserGenres(Long id) {
        //veritabanını kontrol edelim
        // user var mı yok mu
        //varsa genre listesini çekip repoya gönderelim

        Optional<User> optionalUser = userService.findById(id);
        List<Genre> genreList = optionalUser.get().getFavGenres();
        if(genreList.size()>0){
            return movieRepository.findAllByGenresInOrderByRatingDesc(genreList);
        }else {
            throw new RuntimeException("Favlanan Genre yok");
        }
    }
    public List<Movie> findAllByPremieredBefore(LocalDate date) {
        return movieRepository.findAllByPremieredBefore(date);
    }

    public Object[] searchByRating(double rate) {
        return movieRepository.searchByRating(rate);
    }

    public List<Object> searchByRating2() {
        return movieRepository.searchByRating2();
    }

    public List<Movie> findAllByRatingIn() {
        List<Double> ratings = List.of(7D,8D,9D);
        return movieRepository.findAllByRatingIn(ratings);
    }

    public List<Movie> findAllByRatingIn(String[] names) {
        return movieRepository.findAllByNameIn(names);
    }


}
