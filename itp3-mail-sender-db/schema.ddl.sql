DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    customer_number SERIAL UNIQUE NOT NULL,
    customer_name VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(255) UNIQUE NOT NULL,
    marketing_consent BOOLEAN NOT NULL
);

ALTER SEQUENCE customers_customer_number_seq RESTART WITH 10000;