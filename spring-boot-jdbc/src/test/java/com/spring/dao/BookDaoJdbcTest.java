package com.spring.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import com.spring.domain.Author;
import com.spring.domain.Book;
import com.spring.domain.Genre;

@JdbcTest
@Import(BookDaoJdbc.class)
public class BookDaoJdbcTest {
	
	private static final int EXPECTED_BOOK_COUNT = 5;

	private static final long BOOK_ID = 5;

	private static final String BOOK_TITLE = "Anna Karenina";
	
	@Autowired
	private BookDaoJdbc bookDaoJdbc;
	
	@Test
	void count() {
		int count = bookDaoJdbc.count();
		assertThat(count).isEqualTo(EXPECTED_BOOK_COUNT);
	}
	
	@Test
	void insert() {
		Book expectedBook = new Book(6, "Воля к власти");
		Author author = new Author(3, "Herman Melville");
		Genre genre = new Genre(4, "Tragedy");
		
		expectedBook.setAuthor(author);
		expectedBook.setGenre(genre);
		
		bookDaoJdbc.insert(expectedBook);
		Book actualBook = bookDaoJdbc.getById(expectedBook.getId());
		assertThat(actualBook).isEqualTo(expectedBook);
	}
	
	@Test
	void getById() {
		Book actualBook = bookDaoJdbc.getById(BOOK_ID);
		assertThat(actualBook)
				.hasFieldOrPropertyWithValue("id", BOOK_ID)
				.hasFieldOrPropertyWithValue("title", BOOK_TITLE);
	}
}
