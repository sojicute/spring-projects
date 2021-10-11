INSERT INTO GENRES (id, name) VALUES 
	(1, 'Novel'),
	(2, 'Science Fiction'),
	(3, 'Horror'),
	(4, 'Tragedy');

INSERT INTO AUTHORS (id, name) VALUES 
	(1, 'Leo Tolstoy'),
	(2, 'F. Scott Fitzgerald'),
	(3, 'Herman Melville'),
	(4, 'William Shakespeare');

INSERT INTO BOOKS (id, title, genre_id, author_id) VALUES 
	(1, 'War and Peace', 1, 1),
	(2, 'The Great Gatsby', 1, 2),
	(3, 'Moby Dick', 1, 3),
	(4, 'Hamlet', 4, 4),
	(5, 'Anna Karenina', 1, 1);