CREATE DATABASE IF NOT EXISTS adlister_db;

USE tables_lessons_db;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

DROP TABLE IF EXISTS ads;

CREATE TABLE ads(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  title VARCHAR(100) NOT NULL,
  descriptoion TEXT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

SHOW TABLES;
DESCRIBE users;
DESCRIBE ads;

INSERT into users(id, username, email, password) values('1', 'admin', 'email', 'password')
SELECT * from ads