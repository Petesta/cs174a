# Carts Schema

# --- !Ups

CREATE SEQUENCE cart_id_seq;
CREATE TABLE carts (
    id integer NOT NULL DEFAULT nextval('cart_id_seq'),
    createdAt date NOT NULL,
    customerID integer NOT NULL,
    FOREIGN KEY (customerID) REFERENCES customers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE carts;
DROP SEQUENCE cart_id_seq;
