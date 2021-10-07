package com.spring.dao;

import com.spring.domain.Author;
import com.spring.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class GenreDaoJdbc implements GenreDao {
    private NamedParameterJdbcOperations jdbc;

    public GenreDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count(*) from genres", Integer.class);
    }

    @Override
    public void insert(Genre genre) {
        jdbc.update("insert into genres(id, name) values(:id, :name)", Map.of("id", genre.getId(), "name", genre.getName()));
    }

    @Override
    public Genre getById(long id) {
        return jdbc.queryForObject("select * from genres where genres.id = :id", Map.of("id", id), new GenreMapper());
    }

    @Override
    public List<Genre> getAll() {
        return jdbc.query("select * from genres", new GenreMapper());
    }

    @Override
    public void deleteById(long id) {
        jdbc.update("delete from genres where id = :id", Map.of("id", id));
    }

    public static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Genre(id, name);
        }
    }
}
