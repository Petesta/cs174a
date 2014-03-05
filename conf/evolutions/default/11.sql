# InventoryProducts Schema

# --- !Ups

CREATE SEQUENCE inventory_products_id_seq;
CREATE TABLE inventoryProducts (
    id integer NOT NULL DEFAULT nextval('inventory_products_id_seq'),
    stockNumber varchar(10) NOT NULL,
    companyID integer NOT NULL,
    modelID integer NOT NULL,
    replenishment integer NOT NULL,
    qty integer NOT NULL,
    minLvl integer NOT NULL,
    location varchar(20) NOT NULL,
    maxLvl integer NOT NULL,
    PRIMARY KEY (id)
)

# --- !Downs

DROP TABLE inventoryProducts;
DROP SEQUENCE inventory_products_id_seq;
