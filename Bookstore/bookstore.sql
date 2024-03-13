DROP TABLE IF EXISTS book; 
DROP TABLE IF EXISTS category; 
DROP TABLE IF EXISTS app_user;

CREATE TABLE category
(id BIGSERIAL PRIMARY KEY
, name VARCHAR(250) NOT NULL
);


INSERT INTO category (name)
VALUES ('Sci-fi'), ('Fantasia'), ('Dekkari'), ('Kauhu'), ('Rikos'), ('Romantiikka'), ('Draama'), ('Elämänkerta'), ('Tietokirja'), ('Lastenkirja');


CREATE TABLE book 
(id BIGSERIAL PRIMARY KEY
, title VARCHAR(250) NOT NULL
, author VARCHAR(250) NOT NULL
, publicationYear INTEGER NOT NULL
, isbn VARCHAR(13) NOT NULL
, price NUMERIC
, categoryid BIGINT
, FOREIGN KEY (categoryid) REFERENCES category(id));

INSERT INTO book (title, author, publicationYear, isbn, price, categoryid)
VALUES ('Title1', 'Author1', '0001', 'ISBN-00000001', 100.00, 1),
       ('Title2', 'Author2', '0002', 'ISBN-00000002', 200.00, 2),
       ('Title3', 'Author3', '0003', 'ISBN-00000003', 300.00, 3),
       ('Title4', 'Author4', '0004', 'ISBN-00000004', 400.00, 4);


CREATE TABLE app_user
(id BIGSERIAL PRIMARY KEY
, username VARCHAR(250) NOT NULL
, passwordHash VARCHAR(250) NOT NULL
, role  VARCHAR(100) NOT NULL);


INSERT INTO app_user (username, passwordHash, role) 
VALUES ('user', '$2a$10$k3dXqAiLCXzJeMz7rXKH0OgqMnSwu6/SeLej2jSrrlAJcpAxrwZ3u', 'USER'), 
('admin', '$2a$10$1AcJdbfKMbL9.9e8JA1TyOWChGUJAwftbvDSQBdX0R3oodOv9dyuG', 'ADMIN');


SELECT * FROM category;
SELECT * FROM book;
SELECT * FROM app_user;


