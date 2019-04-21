package com.kevinlorenzo.learning.junit.movies.data;

import com.kevinlorenzo.learning.junit.movies.model.Genre;
import com.kevinlorenzo.learning.junit.movies.model.Movie;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    private static RowMapper<Movie> movieMapper = (resultSet, rowNumber) ->
            new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")));

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("SELECT * FROM movies;", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }

}