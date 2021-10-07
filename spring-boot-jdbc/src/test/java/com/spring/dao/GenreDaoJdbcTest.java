package com.spring.dao;

import com.spring.domain.Author;
import com.spring.domain.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(GenreDaoJdbc.class)
class GenreDaoJdbcTest {

    private static final int EXPECTED_GENRE_COUNT = 4;

    private static final long GENRE_ID = 4;

    private static final String GENRE_NAME = "Tragedy";

    @Autowired
    private GenreDaoJdbc genreDaoJdbc;


    @Test
    void count() {
        int count = genreDaoJdbc.count();
        assertThat(count).isEqualTo(EXPECTED_GENRE_COUNT);
    }

    @Test
    void insert() {
        Genre expectedGenre = new Genre(5, "Horror");

        genreDaoJdbc.insert(expectedGenre);
        Genre actualGenre = genreDaoJdbc.getById(expectedGenre.getId());
        assertThat(expectedGenre).isEqualTo(actualGenre);
    }

    @Test
    void getById() {
        Genre actualAuthor = genreDaoJdbc.getById(GENRE_ID);
        assertThat(actualAuthor)
                .hasFieldOrPropertyWithValue("id", GENRE_ID)
                .hasFieldOrPropertyWithValue("name", GENRE_NAME);
    }
}