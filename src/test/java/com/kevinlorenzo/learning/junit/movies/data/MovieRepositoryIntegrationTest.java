package com.kevinlorenzo.learning.junit.movies.data;

import com.kevinlorenzo.learning.junit.movies.model.Genre;
import com.kevinlorenzo.learning.junit.movies.model.Movie;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.hamcrest.CoreMatchers;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class MovieRepositoryIntegrationTest {

    @Test
    public void load_all_movies() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(new JdbcTemplate(dataSource));

        Assert.assertThat(movieRepositoryJdbc.findAll(), CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));

    }

}