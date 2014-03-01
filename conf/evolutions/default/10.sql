# OrdersProducts Schema

# --- !Ups

CREATE SEQUENCE orders_products_id_seq;
CREATE TABLE orders_products (
    id integer NOT NULL DEFAULT nextval('orders_products_id_seq'),
    qty INTEGER NOT NULL DEFAULT 1,
    priceBuy DECIMAL NOT NULL,
    FOREIGN KEY (cat_product_id) REFERENCES cat_product(id),
    FOREIGN KEY (orders_id) REFERENCES orders(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE orders_products;
DROP SEQUENCE orders_products_id_seq;