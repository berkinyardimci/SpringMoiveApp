package com.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String content;
    @Builder.Default
    private LocalDate date = LocalDate.now();
    @ManyToOne
    private User user;
    @ManyToOne
    private Movie movie;

}
