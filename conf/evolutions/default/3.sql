# Models Schema

# --- !Ups

CREATE SEQUENCE model_id_seq;
CREATE TABLE models (
    id integer NOT NULL DEFAULT nextval('model_id_seq'),
    modelNumber varchar(10) NOT NULL,
    companyID integer NOT NULL,
    FOREIGN KEY (companyID) REFERENCES manufacturers(id),
    PRIMARY KEY (id)
);

INSERT INTO models(modelNumber, companyID) VALUES ('model1234', 1);

# --- !Downs

DROP TABLE models;
DROP SEQUENCE model_id_seq;
