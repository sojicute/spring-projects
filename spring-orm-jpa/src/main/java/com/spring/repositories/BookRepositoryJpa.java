package com.spring.repositories;

import com.spring.dao.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJpa {

    Book save(Book book);
    Optional<Book> findById(long id);
    long calcBooksCount();

    List<Book> findAll();

    void updateTitleById(long id, String title);
    void deleteById(long id);
}
