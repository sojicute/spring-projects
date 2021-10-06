package com.spring.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
	@Id
	private final long id;
	private final String title;
	private Author author;
	private Genre genre;
}
