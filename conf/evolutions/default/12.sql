# CartProducts Schema

# --- !Ups

CREATE SEQUENCE cart_products_id_seq;
CREATE TABLE cart_products (
    id integer NOT NULL DEFAULT nextval('cart_products_id_seq'),
    qty INTEGER NOT NULL DEFAULT 1,
    catProductId INTEGER NOT NULL,
    cartId INTEGER NOT NULL,
    FOREIGN KEY (catProductId) REFERENCES cat_product(id),
    FOREIGN KEY (cartId) REFERENCES cart(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cart_products;
DROP SEQUENCE cart_products_id_seq;

