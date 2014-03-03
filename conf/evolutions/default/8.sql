# Accessories Schema

# --- !Ups

CREATE SEQUENCE accessories_id_seq;
CREATE TABLE accessories (
    id integer NOT NULL DEFAULT nextval('accessories_id_seq'),
    productId integer NOT NULL,
    accessoryId integer NOT NULL,
    FOREIGN KEY (productId) REFERENCES cat_product(id),
    FOREIGN KEY (accessoryId) REFERENCES cat_product(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE accessories;
DROP SEQUENCE accessories_id_seq;
