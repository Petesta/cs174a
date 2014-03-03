# Orders Schema

# --- !Ups

CREATE SEQUENCE orders_id_seq;
CREATE TABLE orders (
    id integer NOT NULL DEFAULT nextval('orders_id_seq'),
    createdAt date NOT NULL,
    customerID integer NOT NULL,
    FOREIGN KEY (customerID) REFERENCES customers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE orders;
DROP SEQUENCE orders_id_seq;
