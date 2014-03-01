# Customers Schema

# --- !Ups

CREATE SEQUENCE customer_id_seq;
CREATE TABLE customers (
    id integer NOT NULL DEFAULT nextval('customer_id_seq'),
    firstName char(10) NOT NULL,
    lastName char(10) NOT NULL,
    email char(10) NOT NULL,
    password char(10) NOT NULL,
    street char(10) NOT NULL,
    zip char(10) NOT NULL,
    city char(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE customers;
DROP SEQUENCE customer_id_seq;


# Manufacturer Schema

# --- !Ups

CREATE SEQUENCE manufacturer_id_seq;
CREATE TABLE manufacturer (
    id integer NOT NULL DEFAULT nextval('manufacturer_id_seq'),
    companyName char(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE manufacturer;
DROP SEQUENCE manufacturer_id_seq;

# Model Schema

# --- !Ups

CREATE SEQUENCE model_id_seq;
CREATE TABLE model (
    id integer NOT NULL DEFAULT nextval('model_id_seq'),
    modelNumber char(10) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES manufacturer(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE model;
DROP SEQUENCE model_id_seq;


# Product Schema

# --- !Ups

CREATE SEQUENCE product_id_seq;
CREATE TABLE product (
    id integer NOT NULL DEFAULT nextval('product_id_seq'),
    stockNumber char(5) NOT NULL,
    FOREIGN KEY (model_id) REFERENCES model(id),
    FOREIGN KEY (company_id) REFERENCES manufacturer(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE product;
DROP SEQUENCE product_id_seq;




# Category Schema

# --- !Ups

CREATE SEQUENCE category_id_seq;
CREATE TABLE category (
    id integer NOT NULL DEFAULT nextval('category_id_seq'),
    name char(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE category;
DROP SEQUENCE category_id_seq;


# CatalogProduct Schema

# --- !Ups

CREATE SEQUENCE cat_product_id_seq;
CREATE TABLE cat_product (
    id integer NOT NULL DEFAULT nextval('cat_product_id_seq'),
    stockNumber char(5) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (company_id) REFERENCES manufacturer(id),
    FOREIGN KEY (model_id) REFERENCES model(id),
    FOREIGN KEY (category_id) REFERENCES category(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cat_product;
DROP SEQUENCE cat_product_id_seq;


# Description Schema

# --- !Ups

CREATE SEQUENCE description_id_seq;
CREATE TABLE description (
    id integer NOT NULL DEFAULT nextval('description_id_seq'),
    name char(10) NOT NULL,
    val char(10) NOT NULL,
    FOREIGN KEY (cat_product_id) REFERENCES cat_product(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE category;
DROP SEQUENCE category_id_seq;



# Accessories Schema

# --- !Ups

CREATE SEQUENCE accessories_id_seq;
CREATE TABLE accessories (
    id integer NOT NULL DEFAULT nextval('accessories_id_seq'),
    FOREIGN KEY (product_id) REFERENCES cat_product(id),
    FOREIGN KEY (accessory_id) REFERENCES cat_product(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE accessories;
DROP SEQUENCE accessories_id_seq;


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


# Cart Schema

# --- !Ups

CREATE SEQUENCE cart_id_seq;
CREATE TABLE cart (
    id integer NOT NULL DEFAULT nextval('cart_id_seq'),
    createdAt DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cart;
DROP SEQUENCE cart_id_seq;


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


