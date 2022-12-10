DELETE FROM Blu_rays;
DELETE FROM Roles;
DELETE FROM Movies_Themes;
DELETE FROM Movies;
DELETE FROM Themes;

/*************************************************************/
/*************************  Themes  **************************/
/*************************************************************/

INSERT INTO Themes
VALUES (1, 'Action');
INSERT INTO Themes
VALUES (2, 'Adventure');
INSERT INTO Themes
VALUES (3, 'Animation');
INSERT INTO Themes
VALUES (4, 'Anime');
INSERT INTO Themes
VALUES (5, 'Anthology');
INSERT INTO Themes
VALUES (6, 'Comedy');
INSERT INTO Themes
VALUES (7, 'Crime');
INSERT INTO Themes
VALUES (8, 'Documentary');
INSERT INTO Themes
VALUES (9, 'Drama');
INSERT INTO Themes
VALUES (10, 'Fantastique');
INSERT INTO Themes
VALUES (11, 'Fantasy');
INSERT INTO Themes
VALUES (12, 'Historical');
INSERT INTO Themes
VALUES (13, 'Horror');
INSERT INTO Themes
VALUES (14, 'Musical');
INSERT INTO Themes
VALUES (15, 'Romance');
INSERT INTO Themes
VALUES (16, 'Science fiction');
INSERT INTO Themes
VALUES (17, 'Thriller');
INSERT INTO Themes
VALUES (18, 'Western');

/*************************************************************/
/*************************  MOVIES  **************************/
/*************************************************************/

INSERT INTO Movies
VALUES (0, 'Avatar', to_date('16-12-2009', 'dd-mm-yyyy'),
        'A paraplegic Marine is dispatched to the moon Pandora on a unique mission.', 'PG13',
        'null',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jRXYjXNq0Cs2TcJjLkki24MLp7u.jpg');
INSERT INTO Movies
VALUES (1, 'Avatar: The Way of Water', to_date('14-12-2022', 'dd-mm-yyyy'),
        'Set more than a decade after the events of the first film, learn the story of the Sully family.', 'PG13',
        'null',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg');

/*************************************************************/
/************************  BLU-RAYS  *************************/
/*************************************************************/

INSERT INTO Blu_Rays
VALUES (0, 100000001, 0, 0);
INSERT INTO Blu_Rays
VALUES (1, 100000002, 1, 1);
INSERT INTO Blu_Rays
VALUES (2, 100000003, 0, 2);

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
/**************************  ROLES  **************************/
/*************************************************************/

INSERT INTO ROLES
VALUES (0, 0, 'James Cameron', -1, 1, NULL);
INSERT INTO ROLES
VALUES (1, 0, 'Sam Worthington', 1, -1, 'Jake Sully');
INSERT INTO ROLES
VALUES (2, 0, 'Zoe Saldana', 2, -1, 'Neytiri');
INSERT INTO ROLES
VALUES (3, 0, 'Sigourney Weaver', 3, -1, 'Dr. Grace Augustine');
INSERT INTO ROLES
VALUES (4, 0, 'Stephen Lang', 4, -1, 'Colonel Miles Quaritch');
INSERT INTO ROLES
VALUES (5, 0, 'Michelle Rodriguez', 5, -1, 'Trudy Chacon');
INSERT INTO ROLES
VALUES (6, 1, 'James Cameron', -1, 1, NULL);
INSERT INTO ROLES
VALUES (7, 1, 'Sam Worthington', 1, -1, 'Jake Sully');
INSERT INTO ROLES
VALUES (8, 1, 'Zoe Saldana', 2, -1, 'Neytiri');
INSERT INTO ROLES
VALUES (9, 1, 'Sigourney Weaver', 3, -1, 'Dr. Grace Augustine');
INSERT INTO ROLES
VALUES (10, 1, 'Stephen Lang', 4, -1, 'Colonel Miles Quaritch');
INSERT INTO ROLES
VALUES (11, 1, 'Kate Winslet', 5, -1, 'Ronal');

/*************************************************************/
/**********************  MOVIES THEMES  **********************/
/*************************************************************/

INSERT INTO movies_themes
VALUES (0, 0, 16, 1);
INSERT INTO movies_themes
VALUES (1, 0, 1, 2);
INSERT INTO movies_themes
VALUES (2, 0, 2, 3);
INSERT INTO movies_themes
VALUES (3, 1, 16, 1);
INSERT INTO movies_themes
VALUES (4, 1, 1, 2);
INSERT INTO movies_themes
VALUES (5, 1, 2, 3);

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
