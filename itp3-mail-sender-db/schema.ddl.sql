DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS subscriptions;

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    customer_number SERIAL UNIQUE NOT NULL,
    customer_name VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(256) UNIQUE NOT NULL,
    marketing_consent BOOLEAN NOT NULL
);

CREATE TABLE subscriptions(
	id SERIAL PRIMARY KEY,
	subscription_name VARCHAR(100) UNIQUE NOT NULL,
	subscription_code VARCHAR(10) UNIQUE NOT NULL,
	description VARCHAR(1000) NOT NULL,
	free_subscription BOOLEAN NOT NULL,
	duration_in_months SMALLINT NOT NULL,
	max_mail_num INTEGER NOT NULL
);

