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
        Object[] params = {id};
        return this.jdbcTemplate.queryForObject("SELECT * FROM movies AS m WHERE m.id = ?", params, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM movies;", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        Object[] params = {movie.getName(), movie.getMinutes(), movie.getGenre().toString()};
        this.jdbcTemplate.update("INSERT INTO movies(name, minutes, genre) VALUES(?, ?, ?)", params);
    }

}