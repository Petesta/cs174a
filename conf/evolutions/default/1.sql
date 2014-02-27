# Customers Schema

# --- !Ups

CREATE SEQUENCE customer_id_seq;
CREATE TABLE customers (
    id integer NOT NULL DEFAULT nextval('customer_id_seq'),
    first_name char(10) NOT NULL,
    last_name char(10) NOT NULL,
    email char(10) NOT NULL,
    password char(10) NOT NULL,
    street char(10) NOT NULL,
    zip char(10) NOT NULL,
    city char(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE customers;
DROP SEQUENCE customer_id_seq;
