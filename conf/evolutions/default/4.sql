# Products Schema

# --- !Ups

CREATE SEQUENCE product_id_seq;
CREATE TABLE products (
    id integer NOT NULL DEFAULT nextval('product_id_seq'),
    stockNumber varchar(5) NOT NULL,
    modelID integer NOT NULL,
    companyID integer NOT NULL,
    FOREIGN KEY (modelID) REFERENCES models(id),
    FOREIGN KEY (companyID) REFERENCES manufacturers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE products;
DROP SEQUENCE product_id_seq;
