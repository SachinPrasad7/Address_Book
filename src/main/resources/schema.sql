DROP TABLE IF EXISTS ADDRESS_BOOK;
CREATE TABLE IF NOT EXISTS ADDRESS_BOOK(
    id SERIAL PRIMARY KEY, 
    name VARCHAR(255) NOT NULL, 
    phone VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL
);