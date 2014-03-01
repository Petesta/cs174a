# OrdersProducts Schema

# --- !Ups

CREATE SEQUENCE orders_products_id_seq;
CREATE TABLE orders_products (
    id integer NOT NULL DEFAULT nextval('orders_products_id_seq'),
    qty INTEGER NOT NULL DEFAULT 1,
    priceBuy DECIMAL NOT NULL,
    catProductId INTEGER NOT NULL,
    ordersId INTEGER NOT NULL,
    FOREIGN KEY (catProductId) REFERENCES cat_product(id),
    FOREIGN KEY (ordersId) REFERENCES orders(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE orders_products;
DROP SEQUENCE orders_products_id_seq;