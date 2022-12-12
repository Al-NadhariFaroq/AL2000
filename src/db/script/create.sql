create scheduled eventDROP TABLE themes CASCADE CONSTRAINTS;
DROP TABLE movies CASCADE CONSTRAINTS;
DROP TABLE blu_rays CASCADE CONSTRAINTS;
DROP TABLE subscribers CASCADE CONSTRAINTS;
DROP TABLE rentals CASCADE CONSTRAINTS;
DROP TABLE blu_ray_rentals CASCADE CONSTRAINTS;
DROP TABLE actors CASCADE CONSTRAINTS;
DROP TABLE directors CASCADE CONSTRAINTS;
DROP TABLE movies_themes CASCADE CONSTRAINTS;
DROP TABLE preferences CASCADE CONSTRAINTS;
DROP TABLE scores CASCADE CONSTRAINTS;
DROP TABLE controlled_subscribers CASCADE CONSTRAINTS;
DROP TABLE subscriber_rentals CASCADE CONSTRAINTS;
DROP TABLE non_subscriber_rentals CASCADE CONSTRAINTS;

CREATE TABLE themes (
	theme_id number(8) NOT NULL,
	name     varchar2(100) NOT NULL UNIQUE,
	CONSTRAINT themes_pk PRIMARY KEY (theme_id)
);

CREATE TABLE movies (
	movie_id     number(8) NOT NULL,
	title        varchar2(150) NOT NULL,
	release_date date NOT NULL,
	running_time number(3) NOT NULL,
	rating       varchar2(4) NOT NULL,
	synopsis     varchar2(4000),
	link_url     varchar2(2083) NOT NULL,
	poster_url   varchar2(2083),
	CONSTRAINT movies_pk PRIMARY KEY (movie_id)
);

CREATE TABLE blu_rays (
	blu_ray_id    number(8) NOT NULL,
	serial_number number(16) NOT NULL UNIQUE,
	movie_id      number(8) NOT NULL,
	position      number(3),
	CONSTRAINT blu_rays_pk PRIMARY KEY (blu_ray_id),
	CONSTRAINT blu_rays_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE
);

CREATE TABLE subscribers (
	subscriber_id            number(8) NOT NULL,
	subscription_card_number number(16) NOT NULL UNIQUE,
	credit_card_number       number(16) NOT NULL,
	first_name               varchar2(50) NOT NULL,
	last_name                varchar2(50) NOT NULL,
	email                    varchar2(100) NOT NULL,
	birth_date               date NOT NULL,
	balance                  number(8) NOT NULL,
	CONSTRAINT subscribers_pk PRIMARY KEY (subscriber_id)
);

CREATE TABLE rentals (
	rental_id   number(8) NOT NULL,
	movie_id    number(8) NOT NULL,
	rental_date date NOT NULL,
	CONSTRAINT rentals_pk PRIMARY KEY (rental_id),
	CONSTRAINT movies_rentals_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE
);

CREATE TABLE blu_ray_rentals (
	blu_ray_rental_id number(8) NOT NULL,
	rental_id         number(8) NOT NULL UNIQUE,
	blu_ray_id        number(8) NOT NULL,
	return_date       date,
	CONSTRAINT blu_ray_rentals_pk PRIMARY KEY (blu_ray_rental_id),
	CONSTRAINT blu_ray_rentals_rental_fk FOREIGN KEY (rental_id) REFERENCES rentals (rental_id) ON DELETE CASCADE,
	CONSTRAINT blu_ray_rentals_blu_ray_fk FOREIGN KEY (blu_ray_id) REFERENCES blu_rays (blu_ray_id) ON DELETE CASCADE
);

CREATE TABLE directors (
	director_id   number(8) NOT NULL,
	movie_id      number(8) NOT NULL,
	name          varchar2(100) NOT NULL,
	director_rank number(1) NOT NULL,
	CONSTRAINT directors_pk PRIMARY KEY (director_id),
	CONSTRAINT directors_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE
);

CREATE TABLE actors (
	actor_id   number(8) NOT NULL,
	movie_id   number(8) NOT NULL,
	name       varchar2(100) NOT NULL,
	actor_rank number(1) NOT NULL,
	character  varchar2(100),
	CONSTRAINT actors_pk PRIMARY KEY (actor_id),
	CONSTRAINT actors_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE
);

CREATE TABLE movies_themes (
	movie_theme_id number(8) NOT NULL,
	movie_id       number(8) NOT NULL,
	theme_id       number(8) NOT NULL,
	theme_rank     number(1) NOT NULL,
	CONSTRAINT movies_themes_pk PRIMARY KEY (movie_theme_id),
	CONSTRAINT movies_themes_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE,
	CONSTRAINT movies_themes_theme_fk FOREIGN KEY (theme_id) REFERENCES themes (theme_id) ON DELETE CASCADE
);

CREATE TABLE preferences (
	preference_id number(8) NOT NULL,
	subscriber_id number(8) NOT NULL,
	theme_id      number(8) NOT NULL,
	forbidden     number(1) NOT NULL,
	CONSTRAINT preferences_pk PRIMARY KEY (preference_id),
	CONSTRAINT preferences_subscriber_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers (subscriber_id) ON DELETE CASCADE,
	CONSTRAINT preferences_theme_fk FOREIGN KEY (theme_id) REFERENCES themes (theme_id) ON DELETE CASCADE
);

CREATE TABLE scores (
	score_id      number(8) NOT NULL,
	subscriber_id number(8) NOT NULL,
	movie_id      number(8) NOT NULL,
	score         number(1) NOT NULL,
	CONSTRAINT scores_pk PRIMARY KEY (score_id),
	CONSTRAINT scores_subscriber_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers (subscriber_id) ON DELETE CASCADE,
	CONSTRAINT scores_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE
);

CREATE TABLE controlled_subscribers (
	controlled_subscriber_id number(8) NOT NULL,
	subscriber_id            number(8) NOT NULL,
	sub_subscriber_id        number(8) NOT NULL,
	is_controlled            number(1) NOT NULL,
	CONSTRAINT controlled_subscribers_pk PRIMARY KEY (controlled_subscriber_id),
	CONSTRAINT controlled_subscriber_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers (subscriber_id) ON DELETE CASCADE,
	CONSTRAINT controlled_sub_subscriber_fk FOREIGN KEY (sub_subscriber_id) REFERENCES subscribers (subscriber_id) ON DELETE CASCADE
);

CREATE TABLE non_subscriber_rentals (
	non_subscriber_rental_id number(8) NOT NULL,
	rental_id                number(8) NOT NULL,
	credit_card_number       number(16) NOT NULL,
	CONSTRAINT non_subscriber_rentals_pk PRIMARY KEY (non_subscriber_rental_id),
	CONSTRAINT non_subscriber_rental_fk FOREIGN KEY (rental_id) REFERENCES rentals (rental_id) ON DELETE CASCADE
);

CREATE TABLE subscriber_rentals (
	subscriber_rental_id number(8) NOT NULL,
	rental_id            number(8) NOT NULL,
	subscriber_id        number(8) NOT NULL,
	CONSTRAINT subscriber_rentals_pk PRIMARY KEY (subscriber_rental_id),
	CONSTRAINT subscriber_rentals_fk FOREIGN KEY (rental_id) REFERENCES rentals (rental_id) ON DELETE CASCADE,
	CONSTRAINT subscriber_rental_sub_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers (subscriber_id) ON DELETE CASCADE
);

CREATE OR REPLACE TRIGGER subscriber_minimum_max_age
    BEFORE INSERT OR UPDATE OF birth_date on subscribers
    FOR EACH ROW
DECLARE
min_age integer :=18;
    max_age integer :=200;
    nb integer :=EXTRACT(YEAR FROM sysdate) - EXTRACT(YEAR FROM :new.BIRTH_DATE);
    age_limit_exceeded EXCEPTION;
    PRAGMA exception_init(age_limit_exceeded, -20111);
    min_age_not_reached EXCEPTION;
    PRAGMA exception_init(min_age_not_reached, -20112);
BEGIN
    IF (nb>max_age) THEN
        RAISE_APPLICATION_ERROR(-20111,'The age limit has been exceeded');
ELSE
        IF (nb<min_age) THEN
            RAISE_APPLICATION_ERROR(-20112, 'The minimum age has not been reached');
END IF;
END IF;
END;
/

CREATE OR REPLACE TRIGGER max_rentals_for_non_subscribers
    BEFORE INSERT on NON_SUBSCRIBER_RENTALS
    FOR EACH ROW
DECLARE
nb_non_subscribers INTEGER :=0;
    max_rental_exceeded EXCEPTION;
    PRAGMA exception_init(max_rental_exceeded, -20113);
BEGIN
SELECT COUNT(*) INTO nb_non_subscribers FROM NON_SUBSCRIBER_RENTALS where CREDIT_CARD_NUMBER = :new.credit_card_number;
IF(nb_non_subscribers>0) THEN
DELETE FROM RENTALS WHERE rental_id = :new.rental_id;
RAISE_APPLICATION_ERROR(-20113, 'The customer has reached the maximum number of rentals.');
end if;
end;
/

CREATE OR REPLACE TRIGGER max_rentals_for_subscribers
    BEFORE INSERT on SUBSCRIBER_RENTALS
    FOR EACH ROW
DECLARE
nb_subscribers INTEGER :=0;
    max_rental_exceeded EXCEPTION;
    PRAGMA exception_init(max_rental_exceeded, -20113);
BEGIN
SELECT COUNT(*) INTO nb_subscribers FROM SUBSCRIBER_RENTALS where subscriber_id = :new.subscriber_id;
IF(nb_subscribers>4) THEN
DELETE FROM RENTALS WHERE rental_id = :new.rental_id;
RAISE_APPLICATION_ERROR(-20113, 'The customer has reached the maximum number of rentals.');
end if;
end;
/