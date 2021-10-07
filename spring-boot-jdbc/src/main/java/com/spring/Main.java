package com.spring;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.dao.BookDao;
import com.spring.domain.Author;
import com.spring.domain.Book;
import com.spring.domain.Genre;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class);
		
		BookDao dao = context.getBean(BookDao.class);
		
	
		List<Book> bookList = dao.getAll();
		System.out.println("Book list: \n" + bookList.stream()
				.map(String::valueOf)
				.collect(Collectors.joining("\n"))
		);
	}
	
}
