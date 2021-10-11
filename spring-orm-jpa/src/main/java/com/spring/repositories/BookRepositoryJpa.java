package com.spring.repositories;

import com.spring.dao.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryJpa {

    Book save(Book book);
    Optional<Book> findById(long id);

    List<Book> findAll();
    List<Book> findByTitle(String title);

    void updateNameById(long id, String title);
    void deleteById(long id);
}
