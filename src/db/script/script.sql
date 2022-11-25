DROP TABLE blu_rays CASCADE CONSTRAINTS;
DROP TABLE subscriber_cards;
DROP TABLE cards CASCADE CONSTRAINTS;
DROP TABLE movies_themes CASCADE CONSTRAINTS;
DROP TABLE themes CASCADE CONSTRAINTS;
DROP TABLE rentals CASCADE CONSTRAINTS;
DROP TABLE movies CASCADE CONSTRAINTS;
DROP TABLE professionals CASCADE CONSTRAINTS;
DROP TABLE subscribers CASCADE CONSTRAINTS;
DROP TABLE roles CASCADE CONSTRAINTS;
DROP TABLE restrictions CASCADE CONSTRAINTS;


CREATE TABLE subscribers (
	subscriber_id number(10) NOT NULL,
	email         varchar2(50) NOT NULL,
	card_number   number(16) NOT NULL,
	CONSTRAINT subscribers_pk PRIMARY KEY (subscriber_id),
	CONSTRAINT subscribers_email_unique UNIQUE (email)
);

CREATE TABLE cards (
	card_id     number(10) NOT NULL,
	card_number number(16) NOT NULL,
	CONSTRAINT cards_pk PRIMARY KEY (card_id)
);

CREATE TABLE subscriber_cards (
	subscriber_card_id     number(10) NOT NULL,
	subscriber_card_number number(16) NOT NULL,
	is_subscriber          number(1) NOT NULL,
	cardholder_last_name   varchar2(50) NOT NULL,
	cardholder_first_name  varchar2(50) NOT NULL,
	birth_date             date,
	card_balance           number(10),
	subscriber_id          number(10) NOT NULL,
	CONSTRAINT subscriber_cards_pk PRIMARY KEY (subscriber_card_id),
	CONSTRAINT subscriber_cards_subscriber_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers (subscriber_id)
);

CREATE TABLE movies (
	movie_id      number(10) NOT NULL,
	title        varchar2(100) NOT NULL,
	release_date date,
	synopsis     varchar2(4000),
	rating       number(3),
	age_limit    number(3),
	CONSTRAINT movies_pk PRIMARY KEY (movie_id)
);

CREATE TABLE professionals (
	professional_id number(10) NOT NULL,
	last_name       varchar2(50) NOT NULL,
	first_name      varchar2(50) NOT NULL,
	CONSTRAINT professionals_pk PRIMARY KEY (professional_id)
);

CREATE TABLE blu_rays (
	blu_ray_id       number(10) NOT NULL,
	serial_number    number(16) NOT NULL,
	blu_ray_position number(3),
	movie_id          number(10) NOT NULL,
	CONSTRAINT blu_rays_pk PRIMARY KEY (blu_ray_id),
	CONSTRAINT blu_rays_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
);

CREATE TABLE themes (
	theme_id number(10) NOT NULL,
	theme    varchar2(1000),
	CONSTRAINT themes_pk PRIMARY KEY (theme_id)
);

CREATE TABLE roles (
	role_id         number(10) NOT NULL,
	role_name       varchar2(250),
	is_producer     number(1),
	professional_id number(10) NOT NULL,
	movie_id         number(10) NOT NULL,
	CONSTRAINT roles_pk PRIMARY KEY (role_id),
	CONSTRAINT roles_professional_fk FOREIGN KEY (professional_id) REFERENCES professionals (professional_id),
	CONSTRAINT roles_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
);

CREATE TABLE movies_themes (
	movie_theme_id number(10) NOT NULL,
	movie_id       number(10) NOT NULL,
	theme_id      number(10) NOT NULL,
	CONSTRAINT movies_themes_pk PRIMARY KEY (movie_theme_id),
	CONSTRAINT movies_themes_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id),
	CONSTRAINT movie_themes_theme_fk FOREIGN KEY (theme_id) REFERENCES themes (theme_id)
);

CREATE TABLE restrictions (
	restriction_id number(10) NOT NULL,
	card_number    number(16) NOT NULL,
	theme_id       number(10),
	CONSTRAINT restrictions_pk PRIMARY KEY (restriction_id),
	CONSTRAINT restrictions_theme_fk FOREIGN KEY (theme_id) REFERENCES themes (theme_id)
);

CREATE TABLE rentals (
	rental_id       number(10) NOT NULL,
	card_number     number(16) NOT NULL,
	rental_date     date,
	return_date     date,
	billing_address varchar2(250),
	is_blu_ray      number(10),
	movie_id         number(10) NOT NULL,
	card_id         number(10) NOT NULL,
	CONSTRAINT rentals_pk PRIMARY KEY (rental_id),
	CONSTRAINT rentals_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id),
	CONSTRAINT rentals_card_fk FOREIGN KEY (card_id) REFERENCES cards (card_id)
);



