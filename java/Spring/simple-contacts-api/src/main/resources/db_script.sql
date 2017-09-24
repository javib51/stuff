CREATE DATABASE IF NOT EXISTS `simple-contact-manager`;

USE `simple-contact-manager`;

DROP TABLE IF EXISTS address;

CREATE TABLE address (
       id INTEGER PRIMARY KEY AUTO_INCREMENT, 
       street VARCHAR(40) NOT NULL,
       city  VARCHAR(10) NOT NULL,
       postal_code VARCHAR(30) NOT NULL,
       country VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS contact;
CREATE TABLE contact (
       id INTEGER PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(15) NOT NULL,
       subname VARCHAR(30) NOT NULL,
       phone VARCHAR(13) NOT NULL,
       email VARCHAR(30) DEFAULT NULL,
       website VARCHAR(50) DEFAULT NULL,
       id_address INTEGER UNIQUE,
       FOREIGN KEY(id_address)
       REFERENCES address(id)
);     


/*SELECT table_name FROM information_schema.tables
WHERE table_schema = 'simple-contact-manager'
AND table_name = 'address';
*/
