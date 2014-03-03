# Models Schema

# --- !Ups

CREATE SEQUENCE model_id_seq;
CREATE TABLE models (
    id integer NOT NULL DEFAULT nextval('model_id_seq'),
    modelNumber varchar(10) NOT NULL,
    companyID integer NOT NULL,
    FOREIGN KEY (companyID) REFERENCES manufacturers(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE models;
DROP SEQUENCE model_id_seq;
