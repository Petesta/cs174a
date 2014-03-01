# CartProducts Schema

# --- !Ups

CREATE SEQUENCE cart_products_id_seq;
CREATE TABLE cart_products (
    id integer NOT NULL DEFAULT nextval('cart_products_id_seq'),
    qty INTEGER NOT NULL DEFAULT 1,
    FOREIGN KEY (cat_product_id) REFERENCES cat_product(id),
    FOREIGN KEY (cart_id) REFERENCES cart(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cart_products;
DROP SEQUENCE cart_products_id_seq;

