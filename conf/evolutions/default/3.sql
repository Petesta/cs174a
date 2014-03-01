# Model Schema

# --- !Ups

CREATE SEQUENCE model_id_seq;
CREATE TABLE model (
    id integer NOT NULL DEFAULT nextval('model_id_seq'),
    modelNumber char(10) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES manufacturer(id),
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE model;
DROP SEQUENCE model_id_seq;
