# Customers Schema

# --- !Ups

CREATE SEQUENCE customer_id_seq;
CREATE TABLE customers (
    id integer NOT NULL DEFAULT nextval('customer_id_seq'),
    depotID varchar(10) NOT NULL,
    firstName varchar(10) NOT NULL,
    lastName varchar(10) NOT NULL,
    email varchar(20) NOT NULL,
    password varchar(10) NOT NULL,
    street varchar(64) NOT NULL,
    status varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO customers(depotID, firstName, lastName, email, password, street, status) VALUES ('Rhagrid', 'Rubeus', 'Hagrid', 'rhagrid@cs', 'Rhagrid', '123 MyStreet, Goleta apt A, Ca', 'Gold');
INSERT INTO customers(depotID, firstName, lastName, email, password, street, status) VALUES ('Mhooch', 'Madam', 'Hooch', 'mhooch@cs', 'Mhooch', '123 MyStreet, Goleta apt B, Ca', 'Silver');
INSERT INTO customers(depotID, firstName, lastName, email, password, street, status) VALUES ('Amoody', 'Alastor', 'Moody', 'amoody@cs', 'Amoody', '123 MyStreet, Goleta apt C, Ca', 'New');
INSERT INTO customers(depotID, firstName, lastName, email, password, street, status) VALUES ('Pquirrell', 'Professor', 'Quirrell', 'pquirrell@cs', 'Pquirrell', '123 MyStreet, Goleta apt D, Ca', 'New');
INSERT INTO customers(depotID, firstName, lastName, email, password, street, status) VALUES ('Sblack', 'Sirius', 'Black', 'sblack@cs', 'Sblack', '123 MyStreet, Goleta apt E, Ca', 'Green');
INSERT INTO customers(depotID, firstName, lastName, email, password, street, status) VALUES ('Ddiggle', 'Dedalus', 'Diggle', 'ddiggle@cs', 'Ddiggle', '123 MyStreet, Goleta apt F, Ca', 'Green');

# --- !Downs

DROP TABLE customers;
DROP SEQUENCE customer_id_seq;
