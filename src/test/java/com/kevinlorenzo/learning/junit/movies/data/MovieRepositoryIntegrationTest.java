package com.kevinlorenzo.learning.junit.movies.data;

import com.kevinlorenzo.learning.junit.movies.model.Genre;
import com.kevinlorenzo.learning.junit.movies.model.Movie;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.sql.DataSource;

import org.hamcrest.CoreMatchers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class MovieRepositoryIntegrationTest {

    private DataSource dataSource;

    private MovieRepositoryJdbc movieRepositoryJdbc;

    @Before
    public void setUp() throws SQLException {
        this.dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(this.dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        this.movieRepositoryJdbc = new MovieRepositoryJdbc(new JdbcTemplate(this.dataSource));
    }

    @After
    public void tearDown() throws Exception {
        Statement statement = this.dataSource.getConnection().createStatement();
        statement.execute("DROP ALL OBJECTS DELETE FILES"); // SHUTDOWN for in-memory DB.
    }

    @Test
    public void load_all_movies() {

        Assert.assertThat(this.movieRepositoryJdbc.findAll(), CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));

    }

    @Test
    public void load_movie_by_id() {
        Assert.assertThat(this.movieRepositoryJdbc.findById(2),
                CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    public void insert_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

        this.movieRepositoryJdbc.saveOrUpdate(movie);

        Movie movieFromDb = this.movieRepositoryJdbc.findById(4);

        movie.setId(movieFromDb.getId());

        Assert.assertThat(movieFromDb, CoreMatchers.is(movie));
    }

}