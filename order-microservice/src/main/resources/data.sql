CREATE TABLE IF NOT EXISTS ORDERS (
  ID INTEGER AUTO_INCREMENT PRIMARY KEY,
  PRODUCT_ID INTEGER NOT NULL,
  QUANTITY INTEGER NOT NULL,
  DATE TIMESTAMP NOT NULL
);

INSERT INTO ORDERS (PRODUCT_ID, QUANTITY, DATE) VALUES
  (1, 3, '2024-04-23 22:05:26'),
  (4, 1, '2024-04-29 12:55:30'),
  (3, 5, '2024-04-23 04:30:06');
