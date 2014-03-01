# Manufacturer Schema

# --- !Ups

CREATE SEQUENCE manufacturer_id_seq;
CREATE TABLE manufacturer (
    id integer NOT NULL DEFAULT nextval('manufacturer_id_seq'),
    companyName char(10) NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE manufacturer;
DROP SEQUENCE manufacturer_id_seq;