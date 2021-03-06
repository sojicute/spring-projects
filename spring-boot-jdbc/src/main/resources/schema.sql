DROP TABLE IF EXISTS AUTHORS;

CREATE TABLE AUTHORS(
	ID BIGINT PRIMARY KEY,
	NAME VARCHAR(255)
);

DROP TABLE IF EXISTS GENRES;

CREATE TABLE GENRES(
	ID BIGINT PRIMARY KEY,
	NAME VARCHAR(255)
);


DROP TABLE IF EXISTS BOOKS;

CREATE TABLE BOOKS(
	ID BIGINT PRIMARY KEY,
	TITLE VARCHAR(255),
	AUTHOR_ID BIGINT,
	GENRE_ID BIGINT,
	CONSTRAINT AUTHOR_ID_FK
    FOREIGN KEY (AUTHOR_ID)
    REFERENCES AUTHORS (ID),
    CONSTRAINT GENRE_ID_FK
    FOREIGN KEY (GENRE_ID)
    REFERENCES GENRES (ID)
    
);