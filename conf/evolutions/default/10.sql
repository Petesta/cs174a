# CartProducts Schema

# --- !Ups

CREATE SEQUENCE cart_products_id_seq;
CREATE TABLE cartProducts (
    id integer NOT NULL DEFAULT nextval('cart_products_id_seq'),
    qty integer NOT NULL DEFAULT 1,
    productID integer NOT NULL,
    cartID integer NOT NULL,
    FOREIGN KEY (productID) REFERENCES products(id),
    FOREIGN KEY (cartID) REFERENCES carts(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cartProducts;
DROP SEQUENCE cart_products_id_seq;
