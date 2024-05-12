DROP DATABASE IF EXISTS Library;
CREATE DATABASE IF NOT EXISTS Library;
USE Library;

DROP TABLE IF EXISTS Loan;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Librarian;

CREATE TABLE Librarian(
	pseudonym VARCHAR(45) PRIMARY KEY,
    pwd VARCHAR(45)
    );
    
INSERT INTO Librarian VALUES ('CY-Books', 'Groupe17');

CREATE TABLE Customer(
	id INT PRIMARY KEY,
    firstName VARCHAR(45),
    lastName VARCHAR(45),
    birthDate DATE
    );
    
CREATE TABLE Loan(
	idLoan INT PRIMARY KEY,
    isbn LONG,
    dateLoan DATE,
    plannedDateBack DATE,
    effectiveDateBack DATE,
    late BOOL,
    returned BOOL,
    idCustomer INT,
    FOREIGN KEY fk_Customer(idCustomer) REFERENCES Customer(id)
    );
