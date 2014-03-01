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

