package com.spring;

import com.spring.dao.BookDao;
import com.spring.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class);
		List<Book> books = context.getBean(BookDao.class).getAll();
		System.out.println(books);
	}
	
}
