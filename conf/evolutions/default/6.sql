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
