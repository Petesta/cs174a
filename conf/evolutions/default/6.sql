# Products Schema

# --- !Ups

CREATE SEQUENCE cat_product_id_seq;
CREATE TABLE products (
    id integer NOT NULL DEFAULT nextval('cat_product_id_seq'),
    stockNumber varchar(7) NOT NULL,
    price DOUBLE NOT NULL,
    companyID integer NOT NULL,
    modelID integer NOT NULL,
    categoryID integer NOT NULL,
    description varchar(max),
    FOREIGN KEY (companyID) REFERENCES manufacturers(id),
    FOREIGN KEY (modelID) REFERENCES models(id),
    FOREIGN KEY (categoryID) REFERENCES category(id),
    PRIMARY KEY (id)
);

INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('AA00101', 1630, 1, 1, 1, 'Processor speed: 3.33Ghz, RAM size: 512Mb, Hard disk size: 100Gb, Display size: 17"');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('AA00102', 239, 2, 2, 2, 'Processor speed: 2.53Ghz, RAM size: 256Mb, Hard disk size: 80Gb, OS: none');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('AA00202', 369.99, 3, 3, 2, 'Processor speed: 2.9Ghz, RAM size: 512Mb, Hard disk size: 80Gb');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('AA00301', 69.99, 4, 4, 3, 'Size: 17", Weight: 25lb.');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('AA00302', 279.99, 5, 5, 3, 'Size: 17", Weight: 9.6lb.');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('A00401', 19.99, 6, 6, 4, 'Required disk size: 128MB, Required RAM size: 64MB');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('A00402', 19.99, 7, 6, 4, 'Required disk size:i 128MB, Required RAM size: 64MB');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('A00501', 299.99, 1, 7, 5, 'Resolution: 1200dpi, Sheet capacity: 500, Weight: 0.4lb.');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('A00601', 119.99, 1, 8, 6, 'Resolution: 3.1Mp, Max zoom: 5 times, Weight: 24.7lb.');
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('A00602', 329.99, 8, 8, 6, 'Resolution: 3.1Mp, Max zoom: 5 times, Weight: 24.7lb.');

# --- !Downs

DROP TABLE product;
DROP SEQUENCE cat_product_id_seq;
