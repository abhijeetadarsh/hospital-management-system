CREATE DATABASE IF NOT EXISTS hospital_db;

USE hospital_db;

CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    address VARCHAR(255),
    diagnosis VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    address VARCHAR(255),
    specialization VARCHAR(255)
);
