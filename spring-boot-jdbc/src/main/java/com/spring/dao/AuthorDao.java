package com.spring.dao;

import com.spring.domain.Author;

import java.util.List;

interface AuthorDao {
    int count();

    void insert(Author author);

    Author getById(long id);

    List<Author> getAll();

    void deleteById(long id);
}



