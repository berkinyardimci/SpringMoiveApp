package com.movieapp.util;

import com.google.gson.Gson;
import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.entity.User;
import com.movieapp.repository.IGenreRepository;
import com.movieapp.service.GenreService;
import com.movieapp.service.MovieService;
import com.movieapp.service.UserService;
import com.movieapp.util.data.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {

    private final UserService userService;
    private final MovieService movieService;
    private final GenreService genreService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveAllMoviesFromTvMazetoDB();
    }

    public void saveAllMoviesFromTvMazetoDB() {
        try {
            URL url = new URL("https://api.tvmaze.com/shows");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String value = "";
            value = bufferedReader.readLine();
            Sample[] array = new Gson().fromJson(value, Sample[].class);
            //Arrays.asList(array).forEach(System.out::println);
            Arrays.asList(array).forEach(x -> {
                Movie movie = null;
                if (x.network == null) {
                    movie = Movie.builder()
                            .id(x.id)
                            .url(x.url)
                            .image(x.image.medium)
                            .language(x.language)
                            .premiered(LocalDate.parse(x.premiered))
                            .summary(x.summary)
                            .genres(genreService.createGenresWithName(x.genres))
                            .name(x.name)
                            .rating(x.rating.average)
                            .build();
                } else {
                    movie = Movie.builder()
                            .id(x.id)
                            .url(x.url)
                            .image(x.image.medium)
                            .language(x.language)
                            .premiered(LocalDate.parse(x.premiered))
                            .summary(x.summary)
                            .name(x.name)
                            .genres(genreService.createGenresWithName(x.genres))
                            .country(x.network.country.name)
                            .rating(x.rating.average)
                            .build();
                }
                movieService.save(movie);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser() {
        // 5 tane user oluşturalım
        //favgenres
        //favMovies
        //bazı userler da comment atsın
        User user = User.builder().build();
        User user1 = User.builder().build();
        User user2 = User.builder().build();
    }

}
