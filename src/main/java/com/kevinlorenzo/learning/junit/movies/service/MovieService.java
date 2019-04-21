package com.kevinlorenzo.learning.junit.movies.service;

import com.kevinlorenzo.learning.junit.movies.data.MovieRepository;
import com.kevinlorenzo.learning.junit.movies.model.Genre;
import com.kevinlorenzo.learning.junit.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return this.movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

}