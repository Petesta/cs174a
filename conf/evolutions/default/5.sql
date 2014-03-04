# Category Schema

# --- !Ups

CREATE SEQUENCE category_id_seq;
CREATE TABLE category (
    id integer NOT NULL DEFAULT nextval('category_id_seq'),
    name varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO category(name) VALUES ('Laptop');
INSERT INTO category(name) VALUES ('Desktop');
INSERT INTO category(name) VALUES ('Monitor');
INSERT INTO category(name) VALUES ('Software');
INSERT INTO category(name) VALUES ('Printer');
INSERT INTO category(name) VALUES ('Camera');

# --- !Downs

DROP TABLE category;
DROP SEQUENCE category_id_seq;
