package com.spring.dao;

import com.spring.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@JdbcTest
@Import({AuthorDaoJdbc.class})
class AuthorDaoJdbcTest {

    private static final int EXPECTED_AUTHOR_COUNT = 4;

    private static final long AUTHOR_ID = 4;

    private static final String AUTHOR_NAME = "William Shakespeare";

    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    @Test
    void count() {
        int count = authorDaoJdbc.count();
        assertThat(count).isEqualTo(EXPECTED_AUTHOR_COUNT);
    }

    @Test
    void insert() {
        Author expectedAuthor = new Author(5, "Ницше");

        authorDaoJdbc.insert(expectedAuthor);

        Author actualAuthor = authorDaoJdbc.getById(expectedAuthor.getId());
        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @Test
    void getById() {
        Author actualAuthor = authorDaoJdbc.getById(AUTHOR_ID);
        assertThat(actualAuthor)
                .hasFieldOrPropertyWithValue("id", AUTHOR_ID)
                .hasFieldOrPropertyWithValue("name", AUTHOR_NAME);
    }

    @Test
    void getAll() {

    }
}