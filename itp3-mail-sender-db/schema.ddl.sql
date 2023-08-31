DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS subscriptions;
DROP TABLE IF EXISTS contact_roles;
DROP TABLE IF EXISTS email_templates;

CREATE TABLE contact_roles (
    id SERIAL,
    role_code VARCHAR(5) NOT NULL,
    contact_role_name VARCHAR(100) NOT NULL,
    constraint pk_contact_role_id primary key(id),
    UNIQUE (role_code, contact_role_name)
);

CREATE TABLE customers (
    id SERIAL,
    customer_number SERIAL NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(256) NOT NULL,
    marketing_consent BOOLEAN NOT NULL,
    from_reply_to VARCHAR(256) NOT NULL,
    role_id INTEGER NOT NULL,
    constraint pk_customer_id primary key(id),
    constraint fk_contact_role_id 
			foreign key (role_id)
			references contact_roles(id),
	UNIQUE(customer_number, customer_name, contact_email, from_reply_to)
);

CREATE TABLE subscriptions(
	id SERIAL,
	subscription_name VARCHAR(100) NOT NULL,
	subscription_code VARCHAR(10) NOT NULL,
	description VARCHAR(1000) NOT NULL,
	free_subscription BOOLEAN NOT NULL,
	duration_in_months SMALLINT NOT NULL,
	max_mail_num INTEGER NOT null,
	constraint pk_subscription_id primary key(id),
	UNIQUE(subscription_name, subscription_code)
);

CREATE TABLE email_templates(
	id SERIAL,
	template_identifier VARCHAR(20) UNIQUE NOT NULL,
	template_subject VARCHAR(200) NOT NULL,
	template_body VARCHAR(10000) NOT NULL
);

CREATE TABLE mail_trackers (
	id SERIAL,
	date_time TIMESTAMP NOT NULL,
	subject_length SMALLINT NOT NULL,
	body_length SMALLINT NOT NULL,
	success BOOLEAN NOT NULL,
	message VARCHAR(255)
	CONSTRAINT pk_mail_tracker_id PRIMARY KEY(id)
);

CREATE TABLE headers (
	id SERIAL,
	name VARCHAR(255) NOT NULL,
	value_header TEXT NOT NULL,
	mail_tracker_id SERIAL NOT NULL,
	CONSTRAINT pk_header_id PRIMARY KEY(id),
    CONSTRAINT fk_mail_tracker_id 
		FOREIGN KEY (mail_tracker_id)
		REFERENCES mail_trackers(id)
)

CREATE SEQUENCE IF NOT EXISTS subscriptions_subscription_code_seq
    START WITH 1
    OWNED BY subscriptions.subscription_code;

ALTER SEQUENCE customers_customer_number_seq RESTART WITH 10000;