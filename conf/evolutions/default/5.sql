# Category Schema

# --- !Ups

CREATE SEQUENCE category_id_seq;
CREATE TABLE category (
    id integer NOT NULL DEFAULT nextval('category_id_seq'),
    name char(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE category;
DROP SEQUENCE category_id_seq;