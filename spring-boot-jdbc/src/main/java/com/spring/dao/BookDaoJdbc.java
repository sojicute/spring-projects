package com.spring.dao;

import com.spring.domain.Author;
import com.spring.domain.Book;
import com.spring.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {
    private final NamedParameterJdbcOperations jdbc;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public void insert(Book book) {
        jdbc.update("insert into books(id, title, genre_id, author_id) values(:id, :title, :genre, :author)",
                Map.of("id", book.getId(), "title", book.getTitle(), "genre", book.getGenre().getId(), "author", book.getAuthor().getId()));
    }

    @Override
    public Book getById(long id) {
        return jdbc.queryForObject("select * from books join authors on books.author_id = authors.id join genres on books.genre_id = genres.id where books.id = :id",
                Map.of("id", id), new BookMapper());
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select * from books join authors on books.author_id = authors.id join genres on books.genre_id = genres.id" , new BookMapper());
    }

    @Override
    public void deleteById(long id) {
    	jdbc.update("delete from books where id = :id", Map.of("id", id));
    }

    private static class BookMapper implements RowMapper<Book> {


        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            Book book = new Book(id, title);

            Author author = new Author(resultSet.getLong("author_id"), resultSet.getString("authors.name"));

            Genre genre = new Genre(resultSet.getLong("genre_id"), resultSet.getString("genres.name"));

            book.setAuthor(author);
            book.setGenre(genre);
            return book;
        }
    }
}
