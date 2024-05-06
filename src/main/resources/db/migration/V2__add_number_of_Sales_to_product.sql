ALTER TABLE category
    ADD number_of_sales INT NULL;

ALTER TABLE category
    MODIFY number_of_sales INT NOT NULL;

ALTER TABLE product
    ADD number_of_sales INT NULL;

ALTER TABLE product
    MODIFY number_of_sales INT NOT NULL;
