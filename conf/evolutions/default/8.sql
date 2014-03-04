# Accessory Schema

# --- !Ups

CREATE SEQUENCE accessories_id_seq;
CREATE TABLE accessory (
    id integer NOT NULL DEFAULT nextval('accessories_id_seq'),
    productID integer NOT NULL,
    accessoryID integer NOT NULL,
    FOREIGN KEY (productID) REFERENCES products(id),
    FOREIGN KEY (accessoryID) REFERENCES products(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE accessory;
DROP SEQUENCE accessories_id_seq;
