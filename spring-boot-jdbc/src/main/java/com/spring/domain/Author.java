package com.spring.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Author {
	@Id
	private final long id;
	private final String name;
	
	@MappedCollection(keyColumn = "AUTHOR_ID", idColumn = "AUTHOR_ID")
	private Set<Book> books;
}
