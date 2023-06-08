package com.movieapp.repository;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByRatingGreaterThan(double rate);
    //User ->
    List<Movie> findAllByGenresInOrderByRatingDesc(List<Genre> genres);

    List<Movie> findAllByPremieredBefore(LocalDate date);

    //@Query("select count(m.rating), m.rating from Movie as m group by m.rating having m.rating =?1")
    @Query("select count(m.rating), m.rating from Movie as m where m.rating =?1 group by m.rating")
    Object[] searchByRating(double rating);
    @Query("select count(m.rating), m.rating from Movie as m group by m.rating")
    List<Object> searchByRating2();
    List<Movie> findAllByRatingIn(List<Double> ratings);
    List<Movie> findAllByNameIn(String[] names);

}
