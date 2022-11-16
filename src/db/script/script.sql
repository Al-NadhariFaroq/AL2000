
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
                             CONSTRAINT subscriber_pk PRIMARY KEY (subscriber_id)

);

CREATE TABLE cards (
                       card_id number(10) not null,
                       card_number number(16) not null,
                       billing_address varchar2(250),
                       CONSTRAINT card_pk PRIMARY KEY (card_id)

);

CREATE TABLE subscriberCards (
                                 subscriber_card_id number(10) not null,
                                 subscriber_card_number number(16) not null,
                                 billing_address varchar2(250),
                                 is_subscriber number(1) not null,
                                 cardholder_last_name varchar2(50) not null,
                                 cardholder_first_name varchar2(50) not null,
                                 birth_date Date,
                                 card_balance number(10),
                                 subscriber_id number(10) not null,
                                 CONSTRAINT subscriber_card_pk PRIMARY KEY (subscriber_card_id),
                                 CONSTRAINT subscriber_fk FOREIGN KEY (subscriber_id) REFERENCES subscribers(subscriber_id)

);

CREATE TABLE films (
                       film_id number(10) not null,
                       title varchar2(100) not null,
                       release_date Date,
                       synopsis varchar2,
                       rating number(3),
                       age_limit number(3),
                       CONSTRAINT film_fk PRIMARY KEY (film_id)

);

CREATE TABLE professionals (
                               professional_id number(10) not null,
                               last_name varchar2(50) not null,
                               last_name varchar2(50) not null,
                               CONSTRAINT professional_fk PRIMARY KEY (professional_id)

);

CREATE TABLE rentals (

);



CREATE TABLE roles(

);
CREATE TABLE bluRays (

);

CREATE TABLE themes (

);

CREATE TABLE refills (

);


