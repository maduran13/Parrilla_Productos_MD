CREATE TABLE PRODUCT (
    id INT PRIMARY KEY,
    sequence INT NOT NULL
  );
COPY product FROM 'product.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE SIZE (
    id INT PRIMARY KEY,
    product_id INT not NULL,
    back_soon BOOLEAN NOT NULL,
    special BOOLEAN NOT null,
    FOREIGN key (product_id) REFERENCES PRODUCT(id)
  );

COPY SIZE (id, product_id, back_soon, special) FROM './size.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE STOCK (
    id INT PRIMARY KEY,
    size_id INT UNIQUE not NULL,
    quantity INT NOT null,
    FOREIGN KEY (size_id) REFERENCES SIZE(id)
  );
COPY STOCK (id, size_id, quantity) FROM 'stock.csv' DELIMITER ',' CSV HEADER;