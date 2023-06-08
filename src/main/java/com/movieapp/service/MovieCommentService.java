package com.movieapp.service;

import com.movieapp.entity.Movie;
import com.movieapp.entity.MovieComment;
import com.movieapp.repository.IMovieCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final IMovieCommentRepository movieCommentRepository;

    public List<MovieComment> findAllByMovie_Id(Long id) {
        return movieCommentRepository.findAllByMovie_Id(id);
    }

    public List<MovieComment> findByDate(String name, LocalDate fdate, LocalDate ldate) {
        return movieCommentRepository.findByDate(name,fdate,ldate);
    }
    public List<MovieComment> findByContentContainingIgnoreCase(String value) {
        return movieCommentRepository.findAllByContentContainingIgnoreCase(value);
    }
    public List<MovieComment> findByContentLengthGreaterThan(int length) {
        return movieCommentRepository.findByContentLengthGreaterThan(length);
    }
}
