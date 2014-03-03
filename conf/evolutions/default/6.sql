# CatalogProduct Schema

# --- !Ups

CREATE SEQUENCE cat_product_id_seq;
CREATE TABLE cat_product (
    id integer NOT NULL DEFAULT nextval('cat_product_id_seq'),
    stockNumber varchar(5) NOT NULL,
    productId integer NOT NULL,
    companyId integer NOT NULL,
    modelId integer NOT NULL,
    categoryId integer NOT NULL,
    FOREIGN KEY (productId) REFERENCES product(id),
    FOREIGN KEY (companyId) REFERENCES manufacturer(id),
    FOREIGN KEY (modelId) REFERENCES model(id),
    FOREIGN KEY (categoryId) REFERENCES category(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE cat_product;
DROP SEQUENCE cat_product_id_seq;
