# ShippingNotices Schema

# --- !Ups

CREATE SEQUENCE shipping_notices_id_seq;
CREATE TABLE shippingNotices (
    id integer NOT NULL DEFAULT nextval('shipping_notices_id_seq'),
    companyID integer NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE shippingNotices;
DROP SEQUENCE shipping_notices_id_seq;
