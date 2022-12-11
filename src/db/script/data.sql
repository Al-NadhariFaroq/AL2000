DELETE FROM scores;
DELETE FROM non_subscriber_rentals;
DELETE FROM subscriber_rentals;
DELETE FROM blu_ray_rentals;
DELETE FROM rentals;
DELETE FROM controlled_subscribers;
DELETE FROM subscribers;
DELETE FROM blu_rays;
DELETE FROM actors;
DELETE FROM directors;
DELETE FROM movies_themes;
DELETE FROM movies;
DELETE FROM themes;

/*************************************************************/
/*************************  Themes  **************************/
/*************************************************************/

INSERT INTO themes VALUES (1, 'Action');
INSERT INTO themes VALUES (2, 'Adventure');
INSERT INTO themes VALUES (3, 'Animation');
INSERT INTO themes VALUES (4, 'Anime');
INSERT INTO themes VALUES (5, 'Anthology');
INSERT INTO themes VALUES (6, 'Comedy');
INSERT INTO themes VALUES (7, 'Crime');
INSERT INTO themes VALUES (8, 'Documentary');
INSERT INTO themes VALUES (9, 'Drama');
INSERT INTO themes VALUES (10, 'Fantastique');
INSERT INTO themes VALUES (11, 'Fantasy');
INSERT INTO themes VALUES (12, 'Historical');
INSERT INTO themes VALUES (13, 'Horror');
INSERT INTO themes VALUES (14, 'Musical');
INSERT INTO themes VALUES (15, 'Romance');
INSERT INTO themes VALUES (16, 'Science Fiction');
INSERT INTO themes VALUES (17, 'Thriller');
INSERT INTO themes VALUES (18, 'Western');

/*************************************************************/
/*************************  MOVIES  **************************/
/*************************************************************/

INSERT INTO movies
VALUES (1,
		'Avatar',
		TO_DATE('16/12/2009'),
		162,
		'PG13',
		'A paraplegic Marine is dispatched to the moon Pandora on a unique mission.',
		'https://myflixer.to/watch-movie/avatar-19690.5297449',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg');
INSERT INTO movies
VALUES (2,
		'Avatar: The Way of Water',
		TO_DATE('14/12/2022'),
		192,
		'PG13',
		'Set more than a decade after the events of the first film, learn the story of the Sully family.',
		'Not disponible yet',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg');
INSERT INTO movies
VALUES (3,
		'Baby Driver',
		TO_DATE('19/07/2017'),
		113,
		'R',
		'After being coerced into working for a crime boss, a young getaway driver finds himself taking part in a heist doomed to fail.',
		'https://myflixer.to/watch-movie/baby-driver-19604.5297575',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rmnQ9jKW72bHu8uKlMjPIb2VLMI.jpg');

/*************************************************************/
/************************  BLU-RAYS  *************************/
/*************************************************************/

INSERT INTO blu_rays VALUES (1, 100000001, 1, 0);
INSERT INTO blu_rays VALUES (2, 100000002, 2, 1);
INSERT INTO blu_rays VALUES (3, 100000003, 1, 2);
INSERT INTO blu_rays VALUES (4, 100000004, 3, 3);

/*************************************************************/
/************************ SUBSCRIBERS ************************/
/*************************************************************/

-- INSERT INTO subscribers VALUES ();

/*************************************************************/
/*************************  RENTALS  *************************/
/*************************************************************/

-- INSERT INTO rentals VALUES ();

/*************************************************************/
/*********************  BLU-RAY RENTALS  *********************/
/*************************************************************/

-- INSERT INTO blu_ray_rentals VALUES ();

/*************************************************************/
/************************  DIRECTORS  ************************/
/*************************************************************/

INSERT INTO directors VALUES (1, 1, 'James Cameron', 1);
INSERT INTO directors VALUES (2, 2, 'James Cameron', 1);
INSERT INTO directors VALUES (3, 3, 'Edgar Wright', 1);

/*************************************************************/
/**************************  ACTORS  *************************/
/*************************************************************/

INSERT INTO actors VALUES (1, 1, 'Sam Worthington', 1, 'Jake Sully');
INSERT INTO actors VALUES (2, 1, 'Zoe Saldana', 2, 'Neytiri');
INSERT INTO actors VALUES (3, 1, 'Sigourney Weaver', 3, 'Dr. Grace Augustine');
INSERT INTO actors VALUES (4, 1, 'Stephen Lang', 4, 'Colonel Miles Quaritch');
INSERT INTO actors VALUES (5, 1, 'Michelle Rodriguez', 5, 'Trudy Chacon');
INSERT INTO actors VALUES (6, 2, 'Sam Worthington', 1, 'Jake Sully');
INSERT INTO actors VALUES (7, 2, 'Zoe Saldana', 2, 'Neytiri');
INSERT INTO actors VALUES (8, 2, 'Sigourney Weaver', 3, 'Dr. Grace Augustine');
INSERT INTO actors VALUES (9, 2, 'Stephen Lang', 4, 'Colonel Miles Quaritch');
INSERT INTO actors VALUES (10, 2, 'Kate Winslet', 5, 'Ronal');
INSERT INTO actors VALUES (11, 3, 'Ansel Elgort', 1, 'Miles "Baby"');
INSERT INTO actors VALUES (12, 3, 'Kevin Spacey', 2, 'Doc');
INSERT INTO actors VALUES (13, 3, 'Lily James', 3, 'Debora');
INSERT INTO actors VALUES (14, 3, 'Jon Hamm', 4, 'Jason "Buddy" Van Horn');
INSERT INTO actors VALUES (15, 3, 'Jamie Foxx', 5, 'Leon "Bats" Jefferson III');

/*************************************************************/
/**********************  MOVIES THEMES  **********************/
/*************************************************************/

INSERT INTO movies_themes VALUES (1, 1, 16, 1);
INSERT INTO movies_themes VALUES (2, 1, 1, 2);
INSERT INTO movies_themes VALUES (3, 1, 2, 3);
INSERT INTO movies_themes VALUES (4, 2, 16, 1);
INSERT INTO movies_themes VALUES (5, 2, 1, 2);
INSERT INTO movies_themes VALUES (6, 2, 2, 3);
INSERT INTO movies_themes VALUES (7, 3, 1, 1);
INSERT INTO movies_themes VALUES (8, 3, 7, 2);

/*************************************************************/
/***********************  PREFERENCES  ***********************/
/*************************************************************/

-- INSERT INTO preferences VALUES ();

/*************************************************************/
/**************************  SCORES  *************************/
/*************************************************************/

-- INSERT INTO scores VALUES ();

/*************************************************************/
/*******************  SUBSCRIBER RENTALS  ********************/
/*************************************************************/

-- INSERT INTO subscriber_rentals VALUES ();

/*************************************************************/
/*****************  NON SUBSCRIBER RENTALS  ******************/
/*************************************************************/

-- INSERT INTO non_subscriber_rentals VALUES ();
