# Descriptions Schema

# --- !Ups

CREATE SEQUENCE description_id_seq;
CREATE TABLE descriptions (
    id integer NOT NULL DEFAULT nextval('description_id_seq'),
    name varchar(10) NOT NULL,
    val varchar(10) NOT NULL,
    catProductID integer NOT NULL,
    FOREIGN KEY (catProductID) REFERENCES catalogProducts(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE descriptions;
DROP SEQUENCE description_id_seq;
