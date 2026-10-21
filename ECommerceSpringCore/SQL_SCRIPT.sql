create database core_ecommerce;

USE core_ecommerce;

CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE vendor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DOUBLE,
    stock_quantity INT,
    category_id INT,
    vendor_id INT,

    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (vendor_id) REFERENCES vendor(id)
);


-- CATEGORY VALUES
INSERT INTO category (name, description) VALUES
('Electronics', 'Electronic products'),
('Mobiles', 'Smartphones and mobile devices'),
('Laptops', 'Laptops and notebooks'),
('Accessories', 'Electronic accessories'),
('Home Appliances', 'Home electronic appliances'),
('Gaming', 'Gaming products and accessories');


-- VENDOR VALUES
INSERT INTO vendor (name, email) VALUES
('Samsung', 'samsung@gmail.com'),
('Apple', 'apple@gmail.com'),
('Sony', 'sony@gmail.com'),
('Dell', 'dell@gmail.com'),
('HP', 'hp@gmail.com'),
('Lenovo', 'lenovo@gmail.com');


INSERT INTO product
(name, price, stock_quantity, category_id, vendor_id)
VALUES
('Galaxy S23', 70000, 20, 1, 1),
('Galaxy Buds', 12000, 35, 4, 1),
('Samsung TV', 55000, 10, 5, 1),

('iPhone 15', 75000, 15, 2, 2),
('AirPods Pro', 24000, 25, 4, 2),
('MacBook Air', 95000, 8, 3, 2),

('PlayStation 5', 55000, 12, 6, 3),
('Sony Headphones', 18000, 20, 4, 3),

('Dell Inspiron', 65000, 10, 3, 4),
('Dell Gaming Laptop', 90000, 7, 6, 4),

('HP Pavilion', 68000, 9, 3, 5),

('Lenovo IdeaPad', 60000, 14, 3, 6);