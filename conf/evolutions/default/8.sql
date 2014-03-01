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