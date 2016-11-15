CREATE DATABASE IF NOT EXISTS `test`;
GRANT ALL PRIVILEGES ON `test`.*
TO 'testuser'@'localhost' IDENTIFIED BY 'password'
WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE test;

DROP TABLE IF EXISTS QUERIES;
CREATE TABLE QUERIES
  (
     id               INT(8) PRIMARY KEY AUTO_INCREMENT,
     queryText      TEXT,
     numberOfDigits              INT
  ); 
