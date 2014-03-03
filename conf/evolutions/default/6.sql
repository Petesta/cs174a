# CatalogProducts Schema

# --- !Ups

CREATE SEQUENCE cat_product_id_seq;
CREATE TABLE catalogProducts (
    id integer NOT NULL DEFAULT nextval('cat_product_id_seq'),
    stockNumber varchar(5) NOT NULL,
    productID integer NOT NULL,
    companyID integer NOT NULL,
    modelID integer NOT NULL,
    categoryID integer NOT NULL,
    FOREIGN KEY (productID) REFERENCES products(id),
    FOREIGN KEY (companyID) REFERENCES manufacturers(id),
    FOREIGN KEY (modelID) REFERENCES models(id),
    FOREIGN KEY (categoryID) REFERENCES category(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE catalogProducts;
DROP SEQUENCE cat_product_id_seq;
