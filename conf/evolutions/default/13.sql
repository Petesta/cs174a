# ShippingProducts Schema

# --- !Ups

CREATE SEQUENCE shipping_products_id_seq;
CREATE TABLE shippingProducts (
    id integer NOT NULL DEFAULT nextval('shipping_products_id_seq'),
    stockNumber varchar(10) NOT NULL,
    qty integer NOT NULL,
    shippingNoticeID integer NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE shippingProducts;
DROP SEQUENCE shipping_products_id_seq;
