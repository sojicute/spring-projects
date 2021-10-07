package com.spring.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Genre {
	@Id
	private final long id;
	private final String name;
	
	@MappedCollection(keyColumn = "GENRE_ID", idColumn = "GENRE_ID")
	private Set<Book> books;
}
