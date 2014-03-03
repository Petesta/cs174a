# Customers Schema

# --- !Ups

CREATE SEQUENCE customer_id_seq;
CREATE TABLE customers (
    id integer NOT NULL DEFAULT nextval('customer_id_seq'),
    firstName varchar(10) NOT NULL,
    lastName varchar(10) NOT NULL,
    email varchar(10) NOT NULL,
    password varchar(10) NOT NULL,
    street varchar(10) NOT NULL,
    zip varchar(10) NOT NULL,
    city varchar(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE customers;
DROP SEQUENCE customer_id_seq;
