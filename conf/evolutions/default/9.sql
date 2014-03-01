# Orders Schema

# --- !Ups

CREATE SEQUENCE orders_id_seq;
CREATE TABLE orders (
    id integer NOT NULL DEFAULT nextval('orders_id_seq'),
    createdAt DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE orders;
DROP SEQUENCE orders_id_seq;