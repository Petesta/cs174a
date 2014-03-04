# Manufacturers Schema

# --- !Ups

CREATE SEQUENCE manufacturer_id_seq;
CREATE TABLE manufacturers (
    id integer NOT NULL DEFAULT nextval('manufacturer_id_seq'),
    companyName varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO manufacturers(companyName) VALUES ('HP');
INSERT INTO manufacturers(companyName) VALUES ('Dell');
INSERT INTO manufacturers(companyName) VALUES ('Emachine');
INSERT INTO manufacturers(companyName) VALUES ('Envision');
INSERT INTO manufacturers(companyName) VALUES ('Samsung');
INSERT INTO manufacturers(companyName) VALUES ('Symantec');
INSERT INTO manufacturers(companyName) VALUES ('McAfee');
INSERT INTO manufacturers(companyName) VALUES ('Cannon');

# --- !Downs

DROP TABLE manufacturers;
DROP SEQUENCE manufacturer_id_seq;
