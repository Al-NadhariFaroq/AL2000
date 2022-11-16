DROP TABLE rentals;
DROP TABLE professionals;
DROP TABLE roles;
DROP TABLE bluRays;
DROP TABLE themes;
DROP TABLE refills;
DROP TABLE subscribers;
DROP TABLE cards;
DROP TABLE subscriberCards;
DROP TABLE films;

CREATE TABLE subscribers (
                             subscriber_id number(10) not null,
                             email varchar2(50) not null,
                             card_number number(16) not null,
                             CONSTRAINT subscribers_pk PRIMARY KEY (subscriber_id),
                             CONSTRAINT subscribers_email_unique UNIQUE (email)
);

CREATE TABLE cards (
                       card_id number(10) not null,
                       card_number number(16) not null,
                       billing_address varchar2(250),
                       CONSTRAINT cards_pk PRIMARY KEY (card_id)

);

CREATE TABLE subscriber_cards (
                                  subscriber_card_id number(10) not null,
                                  subscriber_card_number number(16) not null,
                                  billing_address varchar2(250),
                                  is_subscriber number(1) not null,
                                  cardholder_last_name varchar2(50) not null,
                                  cardholder_first_name varchar2(50) not null,
                                  birth_date Date,
                                  card_balance number(10),
                                  subscriber_id number(10) not null,
                                  CONSTRAINT subscriber_cards_pk PRIMARY KEY (subscriber_card_id),
                                  CONSTRAINT subscriber_cards_subscriber_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers(subscriber_id)

);

CREATE TABLE films (
                       film_id number(10) not null,
                       title varchar2(100) not null,
                       release_date Date,
                       synopsis varchar2,
                       rating number(3),
                       age_limit number(3),
                       CONSTRAINT films_pk PRIMARY KEY (film_id)

);

CREATE TABLE professionals (
                               professional_id number(10) not null,
                               last_name varchar2(50) not null,
                               last_name varchar2(50) not null,
                               CONSTRAINT professionals_pk PRIMARY KEY (professional_id)

);

CREATE TABLE blu_rays (
                          blu_ray_id number(10) not null,
                          serial_number number(16) not null,
                          position number(3),
                          film_id number(10) not null,
                          CONSTRAINT blu_rays_pk PRIMARY KEY (blu_ray_id),
                          CONSTRAINT blu_rays_film_fk FOREIGN KEY (film_id) REFERENCES film(film_id)

);

CREATE TABLE themes (
                        theme_id number(10) not null,
                        theme varchar2,
                        CONSTRAINT themes_pk PRIMARY KEY  (theme_id)

);

CREATE TABLE roles(
                      role_id number(10) not null,
                      role_name varchar2,
                      is_producer number(1),
                      professional_id number(10) not null,
                      film_id number(10) not null,
                      CONSTRAINT roles_pk PRIMARY KEY (role_id),
                      CONSTRAINT roles_professional_fk FOREIGN KEY (professional_id) REFERENCES professionals(professional_id),
                      CONSTRAINT roles_film_fk FOREIGN KEY (film_id) REFERENCES films(film_id)

);

CREATE TABLE films_themes (
                              film_theme_id number(10) not null,
                              film_id number(10) not null,
                              theme_id number(10) not null,
                              CONSTRAINT films_themes_pk PRIMARY KEY (film_theme_id),
                              CONSTRAINT films_themes_film_fk FOREIGN KEY (film_id) REFERENCES films(film_id),
                              CONSTRAINT film_themes_theme_fk FOREIGN KEY (theme_id) REFERENCES themes(theme_id),

);


CREATE TABLE restrictions(
                             restriction_id number(10) not null,
                             card_number number(16) not null,
                             theme_id number(10),
                             CONSTRAINT restrictions_pk PRIMARY KEY (restriction_id),
                             CONSTRAINT restrictions_theme_fk  FOREIGN KEY (theme_id) REFERENCES themes(theme_id)

);

CREATE TABLE rentals (
                         rental_id number(10) not null,
                         card_number number(16) not null,
                         rental_date Date,
                         return_date Date,
                         is_blu_ray number(10),
                         film_id number(10) not null,
                         card_id number(10) not null,
                         CONSTRAINT rentals_pk PRIMARY KEY (rental_id),
                         CONSTRAINT rentals_film_fk FOREIGN KEY (film_id) REFERENCES films(film_id),
                         CONSTRAINT rentals_card_fk FOREIGN KEY (card_id) REFERENCES cards(card_id)

);


CREATE TABLE recharges (
                           recharge_id number(10) not null,
                           card_number number(16) not null,
                           amount number(10) not null,
                           recharge_date Date,
                           CONSTRAINT recharges_pk PRIMARY KEY (recharge_id)

);



