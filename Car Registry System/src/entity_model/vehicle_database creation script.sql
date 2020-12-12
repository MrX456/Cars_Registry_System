-- Creating database
CREATE DATABASE vehicle_database
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

-- Use this database
USE vehicle_database;

-- Creating users table
CREATE TABLE tbl_users 
(
	id_user INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(80) NOT NULL,
    sex  VARCHAR(6),  -- Will be modified later
    login VARCHAR(40) NOT NULL,
    user_password VARCHAR(15) NOT NULL,
    user_profile ENUM('administrator', 'user') NOT NULL
) DEFAULT CHARSET = utf8;

-- Rapid description of created users table
DESC tbl_users;

-- Create a administrator user to open the aplication for the first time
INSERT INTO tbl_users(user_name, login, user_password, user_profile)
VALUES ('Administrator', 'admin', 'admin', 'administrator');

-- Changing sex column constraints
ALTER TABLE tbl_users
MODIFY COLUMN sex ENUM('male', 'female') NOT NULL;

-- Table content
SELECT * FROM tbl_users;

-- Rapid description of modified users table
DESC tbl_users;

-- Creating engine models table
CREATE TABLE tbl_engineModel
(
	id_engineModel INT PRIMARY KEY AUTO_INCREMENT,
	engine_model VARCHAR(20) NOT NULL UNIQUE,
    size INT NOT NULL,
    power INT NOT NULL,
    torque INT NOT NULL
) DEFAULT CHARSET = utf8;

-- Rapid description of created engine model table
DESC tbl_engineModel;

-- Creating car table, a engine model can be used in various cars
CREATE TABLE tbl_cars 
(
	id_car INT PRIMARY KEY AUTO_INCREMENT,
    maker VARCHAR(20) NOT NULL,
    model VARCHAR(50) NOT NULL,
    country VARCHAR(25) NOT NULL,
    year_built INT NOT NULL,
    body_type VARCHAR(20) NOT NULL,
    color VARCHAR(15) NOT NULL,
    top_speed INT,
    price DECIMAL(10,2),
    photo LONGBLOB, -- Some image can be stored in this column
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Get actual time from system
    by_user VARCHAR(80) NOT NULL, -- Get who was the user responsable for this registry
    id_engineModel INT NOT NULL,
    FOREIGN KEY(id_engineModel) REFERENCES tbl_engineModel(id_engineModel)
    -- This key join this table with engine model table
) DEFAULT CHARSET = utf8;

-- Rapid description of created cars table
DESC tbl_cars;

-- Show users table content
SELECT * FROM tbl_users;

-- Show engine model table content
SELECT * FROM tbl_engineModel;

-- Show cars table content
SELECT * FROM tbl_cars;




