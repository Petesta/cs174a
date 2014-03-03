# Description Schema

# --- !Ups

CREATE SEQUENCE description_id_seq;
CREATE TABLE description (
    id integer NOT NULL DEFAULT nextval('description_id_seq'),
    name varchar(10) NOT NULL,
    val varchar(10) NOT NULL,
    catProductId INT NOT NULL,
    FOREIGN KEY (catProductId) REFERENCES cat_product(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE category;
DROP SEQUENCE category_id_seq;
