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
);

INSERT INTO inventoryProducts(stockNumber, companyID, modelID, replenishment, qty, minLvl, location, maxLvl) VALUES ('AA00101', 1, 1, 0, 2, 1, 'A9', 10);
INSERT INTO products(stockNumber, price, companyID, modelID, categoryID, description) VALUES ('AA00101', 1630, 1, 1, 1, 'Processor speed: 3.33Ghz, RAM size: 512Mb, Hard disk size: 100Gb, Display size: 17"');

# --- !Downs

DROP TABLE inventoryProducts;
DROP SEQUENCE inventory_products_id_seq;
