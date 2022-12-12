DELETE FROM blu_rays;
DELETE FROM actors;
DELETE FROM directors;
DELETE FROM movies_themes;
DELETE FROM movies;
DELETE FROM themes;
DELETE FROM subscribers;
DELETE FROM preferences;
DELETE FROM scores;
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
INSERT INTO themes VALUES (10, 'Fantastic');
INSERT INTO themes VALUES (11, 'Fantasy');
INSERT INTO themes VALUES (12, 'Historical');
INSERT INTO themes VALUES (13, 'Horror');
INSERT INTO themes VALUES (14, 'Musical');
INSERT INTO themes VALUES (15, 'Romance');
INSERT INTO themes VALUES (16, 'Science Fiction');
INSERT INTO themes VALUES (17, 'Thriller');
INSERT INTO themes VALUES (18, 'Western');
INSERT INTO themes VALUES (19, 'Family');
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
INSERT INTO movies
VALUES (4,
        'The Guardians of the Galaxy Holiday Special',
        TO_DATE('25/11/2022'),
        45,
        'PG12',
        'The Guardians are on a mission to make Christmas unforgettable for Quill and head to Earth in search of the perfect present.',
        'https://myflixer.to/watch-movie/the-guardians-of-the-galaxy-holiday-special-90637.9183430',
        'https://www.themoviedb.org/t/p/original/8dqXyslZ2hv49Oiob9UjlGSHSTR.jpg');
INSERT INTO movies
VALUES (5,
        'The Hip Hop Nutcracker',
        TO_DATE('25/11/2022'),
        44,
        'G',
        'Features Rev Run as he brings audiences on a hip-hop reimagining of The Nutcracker ballet set in NYC.',
        'https://myflixer.to/movie/the-hip-hop-nutcracker-90652',
        'https://www.themoviedb.org/t/p/original/iqOGxcKViTtU7pwC24xUb1bDslw.jpg');
INSERT INTO movies
VALUES (6,
        'The Boss Baby: Christmas Bonus ',
        TO_DATE('06/11/2022'),
        47,
        'G',
        'Christmas Eve takes a twisty turn when the Boss Baby accidentally swaps places with one of Santa''s elves and gets stranded at the North Pole.',
        'https://myflixer.to/movie/the-boss-baby-christmas-bonus-91144',
        'https://www.themoviedb.org/t/p/original/iMmMxF6f2OonUrXrHKBLSYAhXly.jpg');


INSERT INTO movies
VALUES (7,
        'The Last Warrior: Root of Evil',
        TO_DATE('01/01/2021'),
        120,
        'G',
        'Peace and tranquility have set in Belogorie. The evil was defeated and Ivan is now enjoying his well-deserved fame. He is surrounded by his family, friends and small wonders from the modern world that help him lead a comfortable life. Luckily, he has his Magic Sword to cut a gap between the worlds to get some supplies quite regularly. But when an ancient evil rises and the existence of the magic world is put to danger, Ivan has to team up with his old friends and his new rivals. They will set out on a long journey beyond the known world to find a way to defeat the enemies and to return peace to Belogorie.',
        'Not yet available',
        'https://www.themoviedb.org/t/p/original/5VJSIAhSn4qUsg5nOj4MhQhF5wQ.jpg');
INSERT INTO movies
VALUES (8,
        'My Name Is Vendetta',
        TO_DATE('30/11/2022'),
        90,
        'R',
        'After old enemies kill his family, a former mafia enforcer and his feisty daughter flee to Milan, where they hide out while plotting their revenge.',
        'https://myflixer.to/movie/my-name-is-vendetta-90757',
        'https://www.themoviedb.org/t/p/original/7l3war94J4tRyWUiLAGokr3ViF2.jpg');
INSERT INTO movies
VALUES (9,
        'Pinocchio',
        TO_DATE('08/09/2022'),
        105,
        'PG10',
        'A wooden puppet embarks on a thrilling adventure to become a real boy.',
        'https://myflixer.to/movie/pinocchio-87685',
        'https://www.themoviedb.org/t/p/original/iMmMxF6f2OonUrXrHKBLSYAhXly.jpg');

INSERT INTO movies
VALUES (10,
        'Enola Holmes 2',
        TO_DATE('04/11/2022'),
        129,
        'PG12',
        'Now a detective-for-hire like her infamous brother, Enola Holmes takes on her first official case to find a missing girl, as the sparks of a dangerous conspiracy ignite a mystery that requires the help of friends — and Sherlock himself — to unravel.',
        'https://myflixer.to/movie/enola-holmes-2-89869',
        'https://www.themoviedb.org/t/p/original/tegBpjM5ODoYoM1NjaiHVLEA0QM.jpg');
INSERT INTO movies
VALUES (17,
		'Bigger Fatter Liar',
		TO_DATE('18/04/2017'),
		86,
		'PG',
		'Kevin Shepard is a tech-savvy young genius who uses his intelligence to slack off. When greedy video game executive Alan Wolf gets a hold of his ideas for a video game, Kevin and his best friend Becca set off for San Francisco to make Wolf`s life miserable through a series of pranks.',
		'https://myflixer.to/watch-movie/bigger-fatter-liar-56547.5465452',
		'https://www.themoviedb.org/t/p/original/j6jMDEIebIHpZKePOZzhlEDeROW.jpg');

INSERT INTO movies
VALUES (11,
        'The Matrix',
        TO_DATE('30/03/1999'),
        136,
        'PG13',
        'Set in the 22nd century, The Matrix tells the story of a computer hacker that joins a group of underground insurgents fighting the vast and powerful computers who now rule the ground.',
        'https://myflixer.to/movie/the-matrix-19724',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pEoqbqtLc4CcwDUDqxmEDSWpWTZ.jpg');
INSERT INTO movies
VALUES (12,
        'The Terminator',
        TO_DATE('24/04/1984'),
        108,
        'PG13',
        'In the post-apocalyptic future, reigning tyrannical supercomputers teleport a cyborg assassin known as the "Terminator" back to 1984 to kill Sarah Connor, whose unborn son is destined to lead insurgents against 21st century mechanical hegemony. Meanwhile, the human-resistance movement dispatches a lone warrior to safeguard Sarah. Can he stop the virtually indestructible killing machine?',
        'https://myflixer.to/movie/the-terminator-19536',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qvktm0BHcnmDpul4Hz01GIazWPr.jpg');
INSERT INTO movies
VALUES (13,
        'Die Hard',
        TO_DATE('21/09/1998'),
        131,
        'PG13',
        'NYPD cop John McClane''s plan to reconcile with his estranged wife is thrown for a serious loop when, minutes after he arrives at her office, the entire building is overtaken by a group of terrorists. With little help from the LAPD, wisecracking McClane sets out to single-handedly rescue the hostages and bring the bad guys down.',
        'https://myflixer.to/movie/die-hard-19728',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yFihWxQcmqcaBR31QM6Y8gT6aYV.jpg');
INSERT INTO movies
VALUES (14,
           'Shrek',
           TO_DATE('04/07/2001'),
           90,
           'G',
           'It ain''t easy bein'' green -- especially if you''re a likable (albeit smelly) ogre named Shrek. On a mission to retrieve a gorgeous princess from the clutches of a fire-breathing dragon, Shrek teams up with an unlikely compatriot -- a wisecracking donkey.',
           'https://myflixer.to/movie/shrek-19549',
           'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iB64vpL3dIObOtMZgX3RqdVdQDc.jpg');
INSERT INTO movies
VALUES (15,
        'Titanic',
        TO_DATE('07/01/1998'),
        194,
        'PG13',
        '101-year-old Rose DeWitt Bukater tells the story of her life aboard the Titanic, 84 years later. A young Rose boards the ship with her mother and fiancé. Meanwhile, Jack Dawson and Fabrizio De Rossi win third-class tickets aboard the ship. Rose tells the whole story from Titanic''s departure through to its death—on its first and last voyage—on April 15, 1912.',
        'https://myflixer.to/movie/titanic-19586',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg');
INSERT INTO movies
VALUES (16,
        'The Good, the Bad and the Ugly',
        TO_DATE('08/03/1968'),
        161,
        'PG13',
        'While the Civil War rages on between the Union and the Confederacy, three men – a quiet loner, a ruthless hitman, and a Mexican bandit – comb the American Southwest in search of a strongbox containing $200,000 in stolen gold.',
        'https://myflixer.to/movie/the-good-the-bad-and-the-ugly-19502',
        'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bX2xnavhMYjWDoZp1VM6VnU1xwe.jpg');



/*************************************************************/
/************************  BLU-RAYS  *************************/
/*************************************************************/

INSERT INTO blu_rays VALUES (1, 100000001, 1, 0);
INSERT INTO blu_rays VALUES (2, 100000002, 2, 1);
INSERT INTO blu_rays VALUES (3, 100000003, 1, 2);
INSERT INTO blu_rays VALUES (4, 100000004, 3, 3);
INSERT INTO blu_rays VALUES (5, 100000005, 17, 4);
INSERT INTO blu_rays VALUES (6, 100000006, 4, 5);
INSERT INTO blu_rays VALUES (7, 100000007, 5, 6);
INSERT INTO blu_rays VALUES (8, 100000008, 5, 7);
INSERT INTO blu_rays VALUES (9, 100000009, 6, 8);
INSERT INTO blu_rays VALUES (10, 100000010, 6, 9);
INSERT INTO blu_rays VALUES (11, 100000011, 7, 10);
INSERT INTO blu_rays VALUES (12, 100000012, 7, 11);
INSERT INTO blu_rays VALUES (13, 100000013, 8, 12);
INSERT INTO blu_rays VALUES (14, 100000014, 8, 13);
INSERT INTO blu_rays VALUES (15, 100000015, 9, 14);
INSERT INTO blu_rays VALUES (16, 100000016, 9, 15);
INSERT INTO blu_rays VALUES (17, 100000017, 10, 16);
INSERT INTO blu_rays VALUES (18, 100000018, 10, 17);
/*************************************************************/
/************************ SUBSCRIBERS ************************/
/*************************************************************/

INSERT INTO subscribers VALUES(1, 1, 123456, 'Bruce', 'Wayne', 'bruce.wayne@gmail.com', TO_DATE('01/05/1969'), 20);
INSERT INTO subscribers VALUES(2, 2, 234567, 'Peter', 'Parker', 'peter.parker@gmail.com', TO_DATE('01/05/1989'), 17);


/*************************************************************/
/*************************  RENTALS  *************************/
/*************************************************************/

INSERT INTO rentals VALUES (1, 15, TO_DATE('01/05/2022'));
INSERT INTO rentals VALUES (2, 1, TO_DATE('01/08/2022'));
INSERT INTO rentals VALUES (3, 12, TO_DATE('21/04/2022'));
INSERT INTO rentals VALUES (4, 14, TO_DATE('22/01/2022'));
INSERT INTO rentals VALUES (5, 1, TO_DATE('22/03/2022'));


/*************************************************************/
/*********************  BLU-RAY RENTALS  *********************/
/*************************************************************/

INSERT INTO blu_ray_rentals VALUES (1, 2, 1, TO_DATE('01/09/2022'));
INSERT INTO blu_ray_rentals VALUES (2, 5, 1, TO_DATE('22/04/2022'));

/*************************************************************/
/************************  DIRECTORS  ************************/
/*************************************************************/

INSERT INTO directors VALUES (1, 1, 'James Cameron', 1);
INSERT INTO directors VALUES (2, 2, 'James Cameron', 1);
INSERT INTO directors VALUES (3, 3, 'Edgar Wright', 1);
INSERT INTO directors VALUES (4, 17, 'Ron Oliver', 1);
INSERT INTO directors VALUES (5, 5, 'Elizabeth Avellan', 1);
INSERT INTO directors VALUES (6, 5, 'Nikki Parsons', 2);
INSERT INTO directors VALUES (7, 6, 'Matt Engstrom', 1);
INSERT INTO directors VALUES (8, 6, 'Christo Stamboliev', 2);
INSERT INTO directors VALUES (9, 7, 'Dmitriy Dyachenko', 1);
INSERT INTO directors VALUES (10, 8, 'Cosimo Gomez', 1);
INSERT INTO directors VALUES (11, 9, 'Robert Zemeckis', 1);
INSERT INTO directors VALUES (12, 10, 'Harry Bradbeer', 1);
INSERT INTO directors VALUES (51, 11, 'Lilly Wachowski', 1);
INSERT INTO directors VALUES (52, 11, 'Lana Wachowski', 2);
INSERT INTO directors VALUES (53, 12, 'James Cameron', 1);
INSERT INTO directors VALUES (54, 13, 'John McTiernan', 1);
INSERT INTO directors VALUES (55, 14, 'Andrew Adamson', 1);
INSERT INTO directors VALUES (56, 14, 'Vicky Jenson', 2);
INSERT INTO directors VALUES (57, 15, 'James Cameron', 1);
INSERT INTO directors VALUES (58, 16, 'Sergio Leone', 1);







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
INSERT INTO actors VALUES (16, 4, 'Kevin Bacon',1, 'Kevin Bacon' );
INSERT INTO actors VALUES (17, 4, 'Pom Klementieff',2, 'Mantis' );
INSERT INTO actors VALUES (18, 4, 'Chris Pratt',3, 'Peter Quill / Star-Lord' );
INSERT INTO actors VALUES (19, 4, 'Dave Bautista',4, 'Drax the destroyer' );
INSERT INTO actors VALUES (20, 4, 'Vin Diesel',5, 'Groot' );
INSERT INTO actors VALUES (21, 5, 'Joseph Simmons',1, 'Neighborhood MC/Narrator' );
INSERT INTO actors VALUES (22, 5, 'Mikhail Baryshnikov',2, 'Mikhail Baryshnikov' );
INSERT INTO actors VALUES (23, 5, 'Stephen Boss',3, 'Stephen Boss' );
INSERT INTO actors VALUES (24, 5, 'Tiler Peck',4, 'Tiler Peck' );
INSERT INTO actors VALUES (25, 6, 'JP Karliak',1, 'Boss Baby' );
INSERT INTO actors VALUES (26, 6, 'Pierce Gagnon',2, 'Tim' );
INSERT INTO actors VALUES (27, 6, 'Amaryllis Aubel',3, 'French Girl' );
INSERT INTO actors VALUES (28, 6, 'Jodi Benson',4, 'Lala Doo-Da' );
INSERT INTO actors VALUES (29, 7, 'Viktor Horinyak',1, 'Ivan' );
INSERT INTO actors VALUES (30, 7, 'Mila Syvatska',2, 'Vasilisa' );
INSERT INTO actors VALUES (31, 7, 'Ekaterina Vilkova',3, 'Varvara' );
INSERT INTO actors VALUES (32, 7, 'Elena Yakovleva',4, 'Baba Yaga' );
INSERT INTO actors VALUES (33, 8, 'Alessandro Gassmann',1, 'Santo' );
INSERT INTO actors VALUES (34, 8, 'Ginevra Francesconi',2, 'Sofia' );
INSERT INTO actors VALUES (35, 8, 'Remo Girone',3, 'Remo Girone' );
INSERT INTO actors VALUES (36, 8, 'Alessio Praticò',4, 'Alessio Praticò' );
INSERT INTO actors VALUES (37,9, 'Benjamin Evan Ainsworth',1, 'Pinocchio' );
INSERT INTO actors VALUES (38, 9, 'Tom Hanks',2, 'Geppetto' );
INSERT INTO actors VALUES (39, 9, 'Joseph Gordon-Levitt',3, 'Jiminy Cricket' );
INSERT INTO actors VALUES (40, 9, 'Luke Evans',4, 'The Coachman' );
INSERT INTO actors VALUES (41,10, 'Millie Bobby Brown',1, 'Enola Holmes' );
INSERT INTO actors VALUES (42, 10, 'Henry Cavill',2, 'Sherlock Holmes' );
INSERT INTO actors VALUES (43, 10, 'Louis Partridge',3, 'Lord Tewkesbury' );
INSERT INTO actors VALUES (44, 10, 'Helena Bonham Carter',4, 'Eudoria Holmes' );
INSERT INTO actors VALUES (51, 11, 'Keanu Reeves', 1, 'Thomas A. Anderson / Neo');
INSERT INTO actors VALUES (52, 11, 'Laurence Fishburne', 2, 'Morpheus');
INSERT INTO actors VALUES (53, 11, 'Carrie-Anne Moss', 3, 'Trinity');
INSERT INTO actors VALUES (54, 12, 'Arnold Schwarzenegger', 1, 'The Terminator');
INSERT INTO actors VALUES (55, 12, 'Michael Biehn', 2, 'Kyle Reese');
INSERT INTO actors VALUES (56, 12, 'Linda Hamilton', 3, 'Sarah Connor');
INSERT INTO actors VALUES (57, 13, 'Bruce Willis', 1, 'John McClane');
INSERT INTO actors VALUES (58, 13, 'Alan Rickman', 2, 'Hans Gruber');
INSERT INTO actors VALUES (59, 13, 'Alexander Godunov', 3, 'Karl');
INSERT INTO actors VALUES (60, 14, 'Mike Myers', 1, 'Shrek');
INSERT INTO actors VALUES (61, 14, 'Eddie Murphy', 2, 'Donkey');
INSERT INTO actors VALUES (62, 14, 'Cameron Diaz', 3, 'Princess Fiona');
INSERT INTO actors VALUES (63, 14, 'John Lithgow', 4, 'Lord Farquaad');
INSERT INTO actors VALUES (64, 15, 'Leonardo DiCaprio', 1, 'Jack Dawson');
INSERT INTO actors VALUES (65, 15, 'Kate Winslet', 2, 'Rose Dewitt Bukater');
INSERT INTO actors VALUES (66, 16, 'Clint Eastwood', 1, 'Blondie');
INSERT INTO actors VALUES (67, 16, 'Eli Wallach', 2, 'Tuco Ramirez');
INSERT INTO actors VALUES (68, 16, 'Lee Van Cleef', 3, 'Sentenza / Angel Eyes');
INSERT INTO actors VALUES (123, 17, 'Ricky Garcia', 1, 'Kevin Shepard');
INSERT INTO actors VALUES (116, 17, 'Jodelle Ferland', 2, 'Becca');
INSERT INTO actors VALUES (157, 17, 'Barry Bostwick', 3, 'Alan Wolf');

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
INSERT INTO movies_themes VALUES (9, 4, 1, 1);
INSERT INTO movies_themes VALUES (10, 4, 2, 2);
INSERT INTO movies_themes VALUES (11, 4, 16, 3);
INSERT INTO movies_themes VALUES (12, 5, 14, 1);
INSERT INTO movies_themes VALUES (13, 6, 3, 1);
INSERT INTO movies_themes VALUES (14, 6, 2, 2);
INSERT INTO movies_themes VALUES (15, 6, 19, 3);
INSERT INTO movies_themes VALUES (16, 7, 11, 1);
INSERT INTO movies_themes VALUES (17, 7, 2, 2);
INSERT INTO movies_themes VALUES (18, 7, 6, 3);
INSERT INTO movies_themes VALUES (19, 8, 1, 1);
INSERT INTO movies_themes VALUES (20, 8, 2, 2);
INSERT INTO movies_themes VALUES (21, 8, 7, 3);
INSERT INTO movies_themes VALUES (22, 9, 11, 1);
INSERT INTO movies_themes VALUES (23, 9, 1, 2);
INSERT INTO movies_themes VALUES (24, 9, 19, 3);
INSERT INTO movies_themes VALUES (25, 10, 2, 1);
INSERT INTO movies_themes VALUES (26, 10, 6, 2);
INSERT INTO movies_themes VALUES (27, 10, 7, 3);
INSERT INTO movies_themes VALUES (51, 11, 1, 1);
INSERT INTO movies_themes VALUES (52, 11, 16, 2);
INSERT INTO movies_themes VALUES (53, 12, 1, 1);
INSERT INTO movies_themes VALUES (54, 12, 17, 2);
INSERT INTO movies_themes VALUES (55, 12, 16, 3);
INSERT INTO movies_themes VALUES (56, 13, 1, 1);
INSERT INTO movies_themes VALUES (57, 13, 17, 2);
INSERT INTO movies_themes VALUES (58, 14,3 ,1 );
INSERT INTO movies_themes VALUES (59, 14,6 ,2 );
INSERT INTO movies_themes VALUES (60, 14,11 ,3 );
INSERT INTO movies_themes VALUES (61, 14, 2,4 );
INSERT INTO movies_themes VALUES (62, 15, 9,1 );
INSERT INTO movies_themes VALUES (63, 15, 15,2 );
INSERT INTO movies_themes VALUES (64, 16, 18,1 );
INSERT INTO movies_themes VALUES (254, 17, 2, 3);
INSERT INTO movies_themes VALUES (156, 17, 6, 3);


/*************************************************************/
/***********************  PREFERENCES  ***********************/
/*************************************************************/

INSERT INTO preferences VALUES (1, 1, 18, 0);
INSERT INTO preferences VALUES (2, 1, 7, 1);

/*************************************************************/
/**************************  SCORES  *************************/
/*************************************************************/

INSERT INTO scores VALUES (1, 1, 13, 3);

/*************************************************************/
/*******************  SUBSCRIBER RENTALS  ********************/
/*************************************************************/

INSERT INTO subscriber_rentals VALUES (1, 1, 1);
INSERT INTO subscriber_rentals VALUES (2, 2, 1);
INSERT INTO subscriber_rentals VALUES (3, 4, 2);
INSERT INTO subscriber_rentals VALUES (4, 5, 2);

/*************************************************************/
/*****************  NON SUBSCRIBER RENTALS  ******************/
/*************************************************************/

INSERT INTO non_subscriber_rentals VALUES (1, 3, 987654);
