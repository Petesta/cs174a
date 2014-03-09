# Carts Schema

# --- !Ups

CREATE SEQUENCE cart_id_seq;
CREATE TABLE carts (
    id integer NOT NULL DEFAULT nextval('cart_id_seq'),
    createdAt date NOT NULL,
    customerID integer NOT NULL,
    FOREIGN KEY (customerID) REFERENCES customers(id),
    PRIMARY KEY (id)
);

INSERT INTO carts(createdAt, customerID) VALUES ('2014-03-09', 1); 
INSERT INTO carts(createdAt, customerID) VALUES ('2014-03-09', 2); 
INSERT INTO carts(createdAt, customerID) VALUES ('2014-03-09', 3);  
INSERT INTO carts(createdAt, customerID) VALUES ('2014-03-09', 4); 
INSERT INTO carts(createdAt, customerID) VALUES ('2014-03-09', 5); 
INSERT INTO carts(createdAt, customerID) VALUES ('2014-03-09', 6); 

# --- !Downs

DROP TABLE carts;
DROP SEQUENCE cart_id_seq;
