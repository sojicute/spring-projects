package com.spring.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
	@Id
	private long id;
	private String title;
}
