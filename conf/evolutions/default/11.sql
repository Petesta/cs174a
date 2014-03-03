# Cart Schema

# --- !Ups

CREATE SEQUENCE cart_id_seq;
CREATE TABLE cart (
    id integer NOT NULL DEFAULT nextval('cart_id_seq'),
    createdAt date NOT NULL,
    customerId integer NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cart;
DROP SEQUENCE cart_id_seq;
