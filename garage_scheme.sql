CREATE DATABASE garage;
USE garage;

CREATE TABLE customers(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15),
	phone VARCHAR(10)
);

SHOW TABLES;

CREATE TABLE vehicles(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    customer_id INTEGER,
    number_plate VARCHAR(15),
    model VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE services(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(40),
    cost DOUBLE
);

INSERT INTO services(description, cost) VALUES
('oil change', 1500),
('engine repair', 5500),
('Tyre replacement', 3000),
('washing', 500);

SELECT * FROM services;

CREATE TABLE invoices(
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    customer_id INTEGER,
    vehicle_id INTEGER,
    service_id INTEGER,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id),
    FOREIGN KEY (service_id) REFERENCES services(id)
);
    

