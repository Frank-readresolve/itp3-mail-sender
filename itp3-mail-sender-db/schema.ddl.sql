DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS subscriptions;
DROP TABLE IF EXISTS contact_roles;

CREATE TABLE contact_roles (
    id SERIAL,
    role_code VARCHAR(5) UNIQUE NOT NULL,
    contact_role_name VARCHAR(100) UNIQUE NOT NULL,
    constraint pk_contact_role_id primary key(id)
);

CREATE TABLE customers (
    id SERIAL,
    customer_number SERIAL UNIQUE NOT NULL,
    customer_name VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(256) UNIQUE NOT NULL,
    marketing_consent BOOLEAN NOT NULL,
    role_id INTEGER,
    constraint pk_customer_id primary key(id),
    constraint fk_contact_role_id 
			foreign key (role_id)
			references contact_roles(id)
);

CREATE TABLE subscriptions(
	id SERIAL,
	subscription_name VARCHAR(100) UNIQUE NOT NULL,
	subscription_code VARCHAR(10) UNIQUE NOT NULL,
	description VARCHAR(1000) NOT NULL,
	free_subscription BOOLEAN NOT NULL,
	duration_in_months SMALLINT NOT NULL,
	max_mail_num INTEGER NOT null,
	constraint pk_subscription_id primary key(id)
);

CREATE SEQUENCE IF NOT EXISTS subscriptions_subscription_code_seq
    START WITH 1
    OWNED BY subscriptions.subscription_code;

ALTER SEQUENCE customers_customer_number_seq RESTART WITH 10000;