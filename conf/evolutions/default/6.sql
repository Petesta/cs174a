# Product Schema

# --- !Ups

CREATE SEQUENCE cat_product_id_seq;
CREATE TABLE product (
    id integer NOT NULL DEFAULT nextval('cat_product_id_seq'),
    stockNumber varchar(5) NOT NULL,
    companyID integer NOT NULL,
    modelID integer NOT NULL,
    categoryID integer NOT NULL,
    description varchar(max),
    FOREIGN KEY (companyID) REFERENCES manufacturers(id),
    FOREIGN KEY (modelID) REFERENCES models(id),
    FOREIGN KEY (categoryID) REFERENCES category(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE product;
DROP SEQUENCE cat_product_id_seq;
