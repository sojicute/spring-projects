package com.spring.repositories;

import com.spring.dao.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий Book должен")
@DataJpaTest
@Import(BookRepositoryJpaImpl.class)
public class BookRepositoryJpaImplTest {

    private static final int BOOKS_COUNT = 5;

    private static final long FIRST_BOOK_ID = 1;
    private static final String FIRST_BOOK_TITLE = "War and Peace";

    private static final long SECOND_BOOK_ID = 2;
    private static final String NEW_SECOND_BOOK_TITLE = "GATSBY";

    @Autowired
    private BookRepositoryJpaImpl bookRepository;

    @Autowired
    private TestEntityManager em;


    @DisplayName("возвращать список всех книг")
    @Test
    void shouldFindAllBooks() {
        List<Book> books = bookRepository.findAll();
        assertThat(books).hasSize(BOOKS_COUNT);
    }

    @DisplayName("возвращать книгу по id")
    @Test
    void shouldFindBookId() {
        Optional<Book> book  = bookRepository.findById(FIRST_BOOK_ID);
        assertThat(book).isNotEmpty().get()
                .hasFieldOrPropertyWithValue("title", FIRST_BOOK_TITLE);
    }

    @DisplayName("считать общее количество книг")
    @Test
    void shouldCalcBooksCount() {
        long booksCount = bookRepository.calcBooksCount();
        assertThat(booksCount).isEqualTo(BOOKS_COUNT);
    }

    @DisplayName("изменять значения заголовка по id")
    @Test
    void updateBooksTitleById() {
        bookRepository.updateTitleById(SECOND_BOOK_ID, NEW_SECOND_BOOK_TITLE);

        Book secondBook = em.find(Book.class, SECOND_BOOK_ID);
        assertThat(secondBook.getTitle()).isEqualTo(NEW_SECOND_BOOK_TITLE);
    }
}
