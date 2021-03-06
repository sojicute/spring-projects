DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS GENRES;
DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS COMMENTS;

CREATE TABLE AUTHORS(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255)
);

CREATE TABLE GENRES(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(255)
);

CREATE TABLE BOOKS(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	TITLE VARCHAR(255),
	AUTHOR_ID BIGINT REFERENCES AUTHORS(ID)
);

CREATE TABLE COMMENTS(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TEXT VARCHAR(255),
    BOOK_ID BIGINT REFERENCES BOOKS(ID) on delete cascade
);