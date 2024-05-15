CREATE TABLE IF NOT EXISTS PRODUCTS (
  ID INTEGER AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(255) NOT NULL,
  DESCRIPTION VARCHAR(1024) NOT NULL,
  PRICE NUMERIC(10, 2) NOT NULL,
  QUANTITY INTEGER NOT NULL
);

INSERT INTO PRODUCTS (NAME, DESCRIPTION, PRICE, QUANTITY) VALUES
  ('iPhone 15 Pro Max', 'Apple iPhone 15 Pro Max 256 GB Black Titanium', 1199.00, 5),
  ('Samsung Galaxy S30 Ultra', 'Samsung Galaxy S30 Ultra 512 GB Phantom Black', 1099.99, 8),
  ('Sony PlayStation 6', 'Sony PlayStation 6 1TB Gaming Console', 499.00, 10),
  ('MacBook Pro 2024', 'Apple MacBook Pro 2024 13" M1X Chip 512 GB Space Gray', 1799.00, 6),
  ('DJI Mavic Air 3', 'DJI Mavic Air 3 Drone Fly More Combo', 999.00, 4);
