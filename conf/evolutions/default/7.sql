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
