# Model Schema

# --- !Ups

CREATE SEQUENCE model_id_seq;
CREATE TABLE model (
    id integer NOT NULL DEFAULT nextval('model_id_seq'),
    modelNumber char(10) NOT NULL,
    companyId INTEGER NOT NULL,
    FOREIGN KEY (companyId) REFERENCES manufacturer(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE model;
DROP SEQUENCE model_id_seq;
