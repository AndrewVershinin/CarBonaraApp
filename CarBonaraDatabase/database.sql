DROP DATABASE IF EXISTS car_dealership;
CREATE DATABASE car_dealership;
USE car_dealership;

CREATE TABLE dealerships (
	dealership_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
    );
    
    
CREATE TABLE vehicles (
    VIN VARCHAR(17) PRIMARY KEY,  
    make VARCHAR(30),
    model VARCHAR(30),
    year INT,
    color VARCHAR(20),
    price DECIMAL(10,2),
    mileage INT,
    SOLD BOOLEAN DEFAULT FALSE
);

CREATE TABLE inventory (
	dealership_id INT,
    VIN VARCHAR(17),
    PRIMARY KEY (dealership_id, VIN),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE sales_contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    customer_name VARCHAR(50),
    customer_phone VARCHAR(15),
    sale_date DATE,
    sale_price DECIMAL(10,2),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE lease_contracts (
    lease_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    customer_name VARCHAR(50),
    lease_start DATE,
    lease_end DATE,
    monthly_payment DECIMAL(10,2),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

INSERT INTO dealerships (name, address, phone) VALUES
('City Auto Mall', '123 Main St', '555-123-4567'),
('Highway Motors', '456 Highway Rd', '555-987-6543'),
('Budget Cars', '789 Savings Ave', '555-111-2222');

INSERT INTO vehicles (VIN, make, model, year, color, price, mileage, SOLD) VALUES
('1HGCM82633A004352', 'Honda', 'Civic', 2020, 'Blue', 18000.00, 25000, FALSE),
('1N4AL11D75C109151', 'Nissan', 'Altima', 2019, 'Black', 16000.00, 30000, FALSE),
('3FAHP0HA7AR123456', 'Ford', 'Fusion', 2018, 'White', 14000.00, 40000, TRUE),
('1FTFW1EF3EFA12345', 'Ford', 'F-150', 2021, 'Red', 32000.00, 15000, FALSE),
('JH4KA8260MC001234', 'Acura', 'Legend', 2022, 'Silver', 27000.00, 10000, FALSE);

 INSERT INTO inventory (dealership_id, VIN) VALUES
(1, '1HGCM82633A004352'),
(1, '1N4AL11D75C109151'),
(2, '3FAHP0HA7AR123456'),
(2, '1FTFW1EF3EFA12345'),
(3, 'JH4KA8260MC001234');   

INSERT INTO sales_contracts (VIN, customer_name, customer_phone, sale_date, sale_price) VALUES
('3FAHP0HA7AR123456', 'Alice Brown', '555-333-9999', '2025-06-01', 13500.00);

INSERT INTO lease_contracts (VIN, customer_name, lease_start, lease_end, monthly_payment) VALUES
('JH4KA8260MC001234', 'Michael Lee', '2025-06-01', '2028-06-01', 450.00);