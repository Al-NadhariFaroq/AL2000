DELETE FROM preferences;
DELETE FROM scores;
DELETE FROM non_subscriber_rentals;
DELETE FROM subscriber_rentals;
DELETE FROM controlled_subscribers;
DELETE FROM subscribers;
DELETE FROM blu_ray_rentals;
DELETE FROM rentals;
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
		'Big Fat Liar',
		TO_DATE('08/02/2002'),
		88,
		'PG',
		'After one of his class papers is stolen and turned into a movie, a young student and his best friend exact a hilarious, slapstick revenge on the Hollywood hot shot who has taken credit!',
		'https://myflixer.to/watch-movie/big-fat-liar-13876.5312098',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/k1MkctTLNWthU2AUlX4qOCNBlPc.jpg');
INSERT INTO movies
VALUES (5,
		'Bigger Fatter Liar',
		TO_DATE('18/04/2017'),
		86,
		'PG',
		'Kevin Shepard is a tech-savvy young genius who uses his intelligence to slack off. When greedy video game executive Alan Wolf gets a hold of his ideas for a video game, Kevin and his best friend Becca set off for San Francisco to make Wolf`s life miserable through a series of pranks.',
		'https://myflixer.to/watch-movie/bigger-fatter-liar-56547.5465452',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/j6jMDEIebIHpZKePOZzhlEDeROW.jpg');
INSERT INTO movies
VALUES (6,
		'The Matrix',
		TO_DATE('31/03/1999'),
		136,
		'R',
		'Set in the 22nd century, The Matrix tells the story of a computer hacker that joins a group of underground insurgents fighting the vast and powerful computers who now rule the ground.',
		'https://myflixer.to/watch-movie/the-matrix-19724.5349115',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg');
INSERT INTO movies
VALUES (7,
		'The Matrix Reloaded',
		TO_DATE('15/05/2003'),
		138,
		'R',
		'Six months after the events depicted in The Matrix, Neo has proved to be a good omen for the free humans, as more and more humans are being freed from the matrix and brought to Zion, the one and only stronghold of the Resistance.',
		'https://myflixer.to/watch-movie/the-matrix-reloaded-19496.5297749',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9TGHDvWrqKBzwDxDodHYXEmOE6J.jpg');
INSERT INTO movies
VALUES (8,
		'The Matrix Revolutions',
		TO_DATE('05/11/2003'),
		129,
		'R',
		'The human city of Zion defends itself against the massive invasion of the machines as Neo fights to end the war at another front while also opposing the rogue Agent Smith.',
		'https://myflixer.to/watch-movie/the-matrix-revolutions-19370.5298007',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ynMQ4nVwkoP2gLxXXDgcdltihTD.jpg');
INSERT INTO movies
VALUES (9,
		'The Matrix Resurrections',
		TO_DATE('22/12/2021'),
		148,
		'PG',
		'Plagued by strange memories, Neo''s life takes an unexpected turn when he finds himself back inside the Matrix.',
		'https://myflixer.to/watch-movie/the-matrix-resurrections-71395.5606281',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8c4a8kE7PizaGQQnditMmI1xbRp.jpg');
INSERT INTO movies
VALUES (10,
		'The Terminator',
		TO_DATE('26/10/1984'),
		108,
		'G',
		'In the post-apocalyptic future, reigning tyrannical supercomputers teleport a cyborg assassin known as the "Terminator" back to 1984 to kill Sarah Connor, whose unborn son is destined to lead insurgents against 21st century mechanical hegemony.',
		'https://myflixer.to/watch-movie/the-terminator-19536.5349088',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qvktm0BHcnmDpul4Hz01GIazWPr.jpg');
INSERT INTO movies
VALUES (11,
		'Die Hard',
		TO_DATE('22/07/1998'),
		132,
		'R',
		'NYPD cop John McClane''s plan to reconcile with his estranged wife is thrown for a serious loop when, minutes after he arrives at her office, the entire building is overtaken by a group of terrorists.',
		'https://myflixer.to/watch-movie/die-hard-19728.5349046',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yFihWxQcmqcaBR31QM6Y8gT6aYV.jpg');
INSERT INTO movies
VALUES (12,
		'Titanic',
		TO_DATE('19/12/1997'),
		195,
		'G',
		'101-year-old Rose DeWitt Bukater tells the story of her life aboard the Titanic, 84 years later. A young Rose boards the ship with her mother and fiancé. Meanwhile, Jack Dawson and Fabrizio De Rossi win third-class tickets aboard the ship.',
		'https://myflixer.to/watch-movie/titanic-19586.5297602',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg');
INSERT INTO movies
VALUES (13,
		'The Good, the Bad and the Ugly',
		TO_DATE('23/12/1966'),
		161,
		'PG',
		'While the Civil War rages on between the Union and the Confederacy, three men – a quiet loner, a ruthless hitman, and a Mexican bandit – comb the American Southwest in search of a strongbox containing $200,000 in stolen gold.',
		'https://myflixer.to/watch-movie/the-good-the-bad-and-the-ugly-19502.5297758',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bX2xnavhMYjWDoZp1VM6VnU1xwe.jpg');
INSERT INTO movies
VALUES (14,
		'Shrek',
		TO_DATE('22/04/2001'),
		90,
		'G',
		'It ain''t easy bein'' green -- especially if you''re a likable (albeit smelly) ogre named Shrek. On a mission to retrieve a gorgeous princess from the clutches of a fire-breathing dragon, Shrek teams up with an unlikely compatriot -- a wisecracking donkey.',
		'https://myflixer.to/watch-movie/shrek-19549.5297692',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iB64vpL3dIObOtMZgX3RqdVdQDc.jpg');
INSERT INTO movies
VALUES (15,
		'Shrek 2',
		TO_DATE('19/05/2004'),
		93,
		'G',
		'Shrek, Fiona and Donkey set off to Far, Far Away to meet Fiona''s mother and father. But not everyone is happy. Shrek and the King find it hard to get along, and there''s tension in the marriage.',
		'https://myflixer.to/watch-movie/shrek-2-19339.5349343',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2yYP0PQjG8zVqturh1BAqu2Tixl.jpg');
INSERT INTO movies
VALUES (16,
		'Shrek the Third',
		TO_DATE('18/05/2007'),
		93,
		'G',
		'The King of Far Far Away has died and Shrek and Fiona are to become King & Queen. However, Shrek wants to return to his cozy swamp and live in peace and quiet, so when he finds out there is another heir to the throne, they set off to bring him back to rule the kingdom.',
		'https://myflixer.to/watch-movie/shrek-the-third-19136.5298340',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1V5pspgnFCXXWd9DddHBVIF2275.jpg');
INSERT INTO movies
VALUES (17,
		'Shrek Forever After',
		TO_DATE('21/05/2010'),
		93,
		'G',
		'A bored and domesticated Shrek pacts with deal-maker Rumpelstiltskin to get back to feeling like a real ogre again, but when he''s duped and sent to a twisted version of Far Far Away—where Rumpelstiltskin is king, ogres are hunted, and he and Fiona have never met—he sets out to restore his world and reclaim his true love.',
		'https://myflixer.to/watch-movie/shrek-forever-after-19005.5298643',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6HrfPZtKcGmX2tUWW3cnciZTaSD.jpg');
INSERT INTO movies
VALUES (18,
		'The Guardians of the Galaxy Holiday Special',
		TO_DATE('25/11/2022'),
		45,
		'PG13',
		'The Guardians are on a mission to make Christmas unforgettable for Quill and head to Earth in search of the perfect present.',
		'https://myflixer.to/watch-movie/the-guardians-of-the-galaxy-holiday-special-90637.9183430',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8dqXyslZ2hv49Oiob9UjlGSHSTR.jpg');
INSERT INTO movies
VALUES (19,
		'The Hip Hop Nutcracker',
		TO_DATE('25/11/2022'),
		44,
		'G',
		'Features Rev Run as he brings audiences on a hip-hop reimagining of The Nutcracker ballet set in NYC.',
		'https://myflixer.to/watch-movie/the-hip-hop-nutcracker-90652.9183622',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iqOGxcKViTtU7pwC24xUb1bDslw.jpg');
INSERT INTO movies
VALUES (20,
		'The Boss Baby: Christmas Bonus',
		TO_DATE('06/11/2022'),
		47,
		'G',
		'Christmas Eve takes a twisty turn when the Boss Baby accidentally swaps places with one of Santa''s elves and gets stranded at the North Pole.',
		'https://myflixer.to/watch-movie/the-boss-baby-christmas-bonus-91144.9213736',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iMmMxF6f2OonUrXrHKBLSYAhXly.jpg');
INSERT INTO movies
VALUES (21,
		'The Last Warrior: Root of Evil',
		TO_DATE('01/01/2021'),
		120,
		'PG',
		'Peace and tranquility have set in Belogorie. The evil was defeated and Ivan is now enjoying his well-deserved fame. He is surrounded by his family, friends and small wonders from the modern world that help him lead a comfortable life. Luckily, he has his Magic Sword to cut a gap between the worlds to get some supplies quite regularly. But when an ancient evil rises and the existence of the magic world is put to danger, Ivan has to team up with his old friends and his new rivals. They will set out on a long journey beyond the known world to find a way to defeat the enemies and to return peace to Belogorie.',
		'https://myflixer.to/watch-movie/the-last-warrior-root-of-evil-87640.8943343',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5VJSIAhSn4qUsg5nOj4MhQhF5wQ.jpg');
INSERT INTO movies
VALUES (22,
		'My Name Is Vendetta',
		TO_DATE('30/11/2022'),
		90,
		'R',
		'After old enemies kill his family, a former mafia enforcer and his feisty daughter flee to Milan, where they hide out while plotting their revenge.',
		'https://myflixer.to/watch-movie/my-name-is-vendetta-90757.9190996',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7l3war94J4tRyWUiLAGokr3ViF2.jpg');
INSERT INTO movies
VALUES (23,
		'Pinocchio',
		TO_DATE('08/09/2022'),
		105,
		'PG13',
		'A wooden puppet embarks on a thrilling adventure to become a real boy.',
		'https://myflixer.to/watch-movie/pinocchio-87685.8932804',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/g8sclIV4gj1TZqUpnL82hKOTK3B.jpg');
INSERT INTO movies
VALUES (24,
		'Enola Holmes',
		TO_DATE('23/09/2020'),
		123,
		'PG13',
		'While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord.',
		'https://myflixer.to/watch-movie/enola-holmes-63478.5477455',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/riYInlsq2kf1AWoGm80JQW5dLKp.jpg');
INSERT INTO movies
VALUES (25,
		'Enola Holmes 2',
		TO_DATE('04/11/2022'),
		129,
		'PG13',
		'Now a detective-for-hire like her infamous brother, Enola Holmes takes on her first official case to find a missing girl, as the sparks of a dangerous conspiracy ignite a mystery that requires the help of friends — and Sherlock himself — to unravel.',
		'https://myflixer.to/watch-movie/enola-holmes-2-89869.9121387',
		'https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tegBpjM5ODoYoM1NjaiHVLEA0QM.jpg');

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

INSERT INTO subscribers
VALUES (1, 1, 000000, 'Technician', 'Technician', 'technical.service@gmail.com', TO_DATE('01/05/1969'), 0);
INSERT INTO subscribers VALUES (2, 2, 123456, 'Bruce', 'Wayne', 'bruce.wayne@gmail.com', TO_DATE('01/05/1969'), 20);
INSERT INTO subscribers VALUES (3, 3, 234567, 'Peter', 'Parker', 'peter.parker@gmail.com', TO_DATE('01/05/1989'), 17);

/*************************************************************/
/*************************  RENTALS  *************************/
/*************************************************************/

INSERT INTO rentals VALUES (1, 4, TO_DATE('01/05/2022'));
INSERT INTO rentals VALUES (2, 1, TO_DATE('01/08/2022'));
INSERT INTO rentals VALUES (3, 6, TO_DATE('21/04/2022'));
INSERT INTO rentals VALUES (4, 3, TO_DATE('22/01/2022'));
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
INSERT INTO directors VALUES (4, 4, 'Shawn Levy', 1);
INSERT INTO directors VALUES (5, 5, 'Ron Oliver', 1);
INSERT INTO directors VALUES (6, 6, 'Lilly Wachowski', 1);
INSERT INTO directors VALUES (7, 6, 'Lana Wachowski', 2);
INSERT INTO directors VALUES (8, 7, 'Lilly Wachowski', 1);
INSERT INTO directors VALUES (9, 7, 'Lana Wachowski', 2);
INSERT INTO directors VALUES (10, 8, 'Lilly Wachowski', 1);
INSERT INTO directors VALUES (11, 8, 'Lana Wachowski', 2);
INSERT INTO directors VALUES (12, 9, 'Lana Wachowski', 1);
INSERT INTO directors VALUES (13, 10, 'James Cameron', 1);
INSERT INTO directors VALUES (14, 11, 'John McTiernan', 1);
INSERT INTO directors VALUES (15, 12, 'James Cameron', 1);
INSERT INTO directors VALUES (16, 13, 'Sergio Leone', 1);
INSERT INTO directors VALUES (17, 14, 'Andrew Adamson', 1);
INSERT INTO directors VALUES (18, 14, 'Vicky Jenson', 2);
INSERT INTO directors VALUES (19, 15, 'Andrew Adamson', 1);
INSERT INTO directors VALUES (20, 15, 'Kelly Asbury', 2);
INSERT INTO directors VALUES (21, 15, 'Conrad Vernon', 3);
INSERT INTO directors VALUES (22, 16, 'Chris Miller', 1);
INSERT INTO directors VALUES (23, 17, 'Mike Mitchell', 1);
INSERT INTO directors VALUES (24, 18, 'Elizabeth Avellan', 1);
INSERT INTO directors VALUES (25, 19, 'Nikki Parsons', 1);
INSERT INTO directors VALUES (26, 20, 'Matt Engstrom', 1);
INSERT INTO directors VALUES (27, 20, 'Christo Stamboliev', 2);
INSERT INTO directors VALUES (28, 21, 'Dmitriy Dyachenko', 1);
INSERT INTO directors VALUES (29, 22, 'Cosimo Gomez', 1);
INSERT INTO directors VALUES (30, 23, 'Robert Zemeckis', 1);
INSERT INTO directors VALUES (31, 24, 'Harry Bradbeer', 1);
INSERT INTO directors VALUES (32, 25, 'Harry Bradbeer', 1);

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
INSERT INTO actors VALUES (16, 4, 'Frankie Muniz', 1, 'Jason Shepherd');
INSERT INTO actors VALUES (17, 4, 'Paul Giamatti', 2, 'Marty Wolf');
INSERT INTO actors VALUES (18, 4, 'Amanda Bynes', 3, 'Kaylee');
INSERT INTO actors VALUES (19, 4, 'Amanda Detmer', 4, 'Monty Kirkham');
INSERT INTO actors VALUES (20, 4, 'Sandra Oh', 5, 'Mrs. Caldwell');
INSERT INTO actors VALUES (21, 5, 'Ricky Garcia', 1, 'Kevin Shepard');
INSERT INTO actors VALUES (22, 5, 'Barry Bostwick', 2, 'Alan Wolf');
INSERT INTO actors VALUES (23, 5, 'Jodelle Ferland', 3, 'Becca');
INSERT INTO actors VALUES (24, 5, 'Andrew Herr', 4, 'Gunner');
INSERT INTO actors VALUES (25, 5, 'April Telek', 5, 'Judy');
INSERT INTO actors VALUES (26, 6, 'Keanu Reeves', 1, 'Thomas A. Anderson / Neo');
INSERT INTO actors VALUES (27, 6, 'Laurence Fishburne', 2, 'Morpheus');
INSERT INTO actors VALUES (28, 6, 'Carrie-Anne Moss', 3, 'Trinity');
INSERT INTO actors VALUES (29, 6, 'Hugo Weaving', 4, 'Agent Smith');
INSERT INTO actors VALUES (30, 6, 'Joe Pantoliano', 5, 'Cypher');
INSERT INTO actors VALUES (31, 7, 'Keanu Reeves', 1, 'Thomas A. Anderson / Neo');
INSERT INTO actors VALUES (32, 7, 'Laurence Fishburne', 2, 'Morpheus');
INSERT INTO actors VALUES (33, 7, 'Carrie-Anne Moss', 3, 'Trinity');
INSERT INTO actors VALUES (34, 7, 'Hugo Weaving', 4, 'Agent Smith');
INSERT INTO actors VALUES (35, 7, 'Jada Pinkett Smith', 5, 'Niobe');
INSERT INTO actors VALUES (36, 8, 'Keanu Reeves', 1, 'Thomas A. Anderson / Neo');
INSERT INTO actors VALUES (37, 8, 'Laurence Fishburne', 2, 'Morpheus');
INSERT INTO actors VALUES (38, 8, 'Carrie-Anne Moss', 3, 'Trinity');
INSERT INTO actors VALUES (39, 8, 'Hugo Weaving', 4, 'Agent Smith');
INSERT INTO actors VALUES (40, 8, 'Jada Pinkett Smith', 5, 'Niobe');
INSERT INTO actors VALUES (41, 9, 'Keanu Reeves', 1, 'Thomas A. Anderson / Neo');
INSERT INTO actors VALUES (42, 9, 'Carrie-Anne Moss', 2, 'Tiffany / Trinity');
INSERT INTO actors VALUES (43, 9, 'Yahya Abdul-Mateen II', 2, 'Morpheus / Agent Smith');
INSERT INTO actors VALUES (44, 9, 'Jessica Henwick', 4, 'Bugs');
INSERT INTO actors VALUES (45, 9, 'Jonathan Groff', 5, 'Smith');
INSERT INTO actors VALUES (46, 10, 'Arnold Schwarzenegger', 1, 'The Terminator');
INSERT INTO actors VALUES (47, 10, 'Michael Biehn', 2, 'Kyle Reese');
INSERT INTO actors VALUES (48, 10, 'Linda Hamilton', 3, 'Sarah Connor');
INSERT INTO actors VALUES (49, 10, 'Paul Winfield', 4, 'Lieutenant Ed Traxler');
INSERT INTO actors VALUES (50, 10, 'Lance Henriksen', 5, 'Detective Vukovich');
INSERT INTO actors VALUES (51, 11, 'Bruce Willis', 1, 'John McClane');
INSERT INTO actors VALUES (52, 11, 'Alan Rickman', 2, 'Hans Gruber');
INSERT INTO actors VALUES (53, 11, 'Alexander Godunov', 3, 'Karl');
INSERT INTO actors VALUES (54, 11, 'Bonnie Bedelia', 4, 'Holly Gennaro McClane');
INSERT INTO actors VALUES (55, 11, 'Reginald VelJohnson', 5, 'Al Powell');
INSERT INTO actors VALUES (56, 12, 'Leonardo DiCaprio', 1, 'Jack Dawson');
INSERT INTO actors VALUES (57, 12, 'Kate Winslet', 2, 'Rose Dewitt Bukater');
INSERT INTO actors VALUES (58, 12, 'Billy Zane', 3, 'Cal Hockley');
INSERT INTO actors VALUES (59, 12, 'Gloria Stuart', 4, 'Old Rose');
INSERT INTO actors VALUES (60, 12, 'Kathy Bates', 5, 'Molly Brown');
INSERT INTO actors VALUES (61, 13, 'Clint Eastwood', 1, 'Blondie');
INSERT INTO actors VALUES (62, 13, 'Eli Wallach', 2, 'Tuco Ramirez');
INSERT INTO actors VALUES (63, 13, 'Lee Van Cleef', 3, 'Sentenza / Angel Eyes');
INSERT INTO actors VALUES (64, 13, 'Aldo Giuffrè', 4, 'Alcoholic Union Captain');
INSERT INTO actors VALUES (65, 13, 'Luigi Pistilli', 5, 'Father Pablo Ramirez');
INSERT INTO actors VALUES (66, 14, 'Mike Myers', 1, 'Shrek');
INSERT INTO actors VALUES (67, 14, 'Eddie Murphy', 2, 'Donkey');
INSERT INTO actors VALUES (68, 14, 'Cameron Diaz', 3, 'Princess Fiona');
INSERT INTO actors VALUES (69, 14, 'John Lithgow', 4, 'Lord Farquaad');
INSERT INTO actors VALUES (70, 14, 'Vincent Cassel', 5, 'Monsieur Hood');
INSERT INTO actors VALUES (71, 15, 'Mike Myers', 1, 'Shrek');
INSERT INTO actors VALUES (72, 15, 'Eddie Murphy', 2, 'Donkey');
INSERT INTO actors VALUES (73, 15, 'Cameron Diaz', 3, 'Princess Fiona');
INSERT INTO actors VALUES (74, 15, 'Julie Andrews', 4, 'Queen');
INSERT INTO actors VALUES (75, 15, 'Antonio Banderas', 5, 'Puss in Boots');
INSERT INTO actors VALUES (76, 16, 'Mike Myers', 1, 'Shrek');
INSERT INTO actors VALUES (77, 16, 'Eddie Murphy', 2, 'Donkey');
INSERT INTO actors VALUES (78, 16, 'Cameron Diaz', 3, 'Princess Fiona');
INSERT INTO actors VALUES (79, 16, 'Antonio Banderas', 4, 'Puss in Boots');
INSERT INTO actors VALUES (80, 16, 'Julie Andrews', 5, 'Queen');
INSERT INTO actors VALUES (81, 17, 'Mike Myers', 1, 'Shrek');
INSERT INTO actors VALUES (82, 17, 'Eddie Murphy', 2, 'Donkey');
INSERT INTO actors VALUES (83, 17, 'Cameron Diaz', 3, 'Princess Fiona');
INSERT INTO actors VALUES (84, 17, 'Antonio Banderas', 4, 'Puss in Boots');
INSERT INTO actors VALUES (85, 17, 'Walt Dohrn', 5, 'Rumpelstiltskin / Priest / Krekraw Ogre');
INSERT INTO actors VALUES (86, 18, 'Kevin Bacon', 1, 'Kevin Bacon');
INSERT INTO actors VALUES (87, 18, 'Pom Klementieff', 2, 'Mantis');
INSERT INTO actors VALUES (88, 18, 'Chris Pratt', 3, 'Peter Quill / Star-Lord');
INSERT INTO actors VALUES (89, 18, 'Dave Bautista', 4, 'Drax the destroyer');
INSERT INTO actors VALUES (90, 18, 'Vin Diesel', 5, 'Groot');
INSERT INTO actors VALUES (91, 19, 'Joseph Simmons', 1, 'Neighborhood MC/Narrator');
INSERT INTO actors VALUES (92, 19, 'Mikhail Baryshnikov', 2, 'Mikhail Baryshnikov');
INSERT INTO actors VALUES (93, 19, 'Stephen Boss', 3, 'Stephen Boss');
INSERT INTO actors VALUES (94, 19, 'Tiler Peck', 4, 'Tiler Peck');
INSERT INTO actors VALUES (95, 19, 'Viktor White', 5, 'Viktor White');
INSERT INTO actors VALUES (96, 6, 'JP Karliak', 1, 'Boss Baby');
INSERT INTO actors VALUES (97, 6, 'Pierce Gagnon', 2, 'Tim');
INSERT INTO actors VALUES (98, 6, 'Amaryllis Aubel', 3, 'French Girl');
INSERT INTO actors VALUES (99, 6, 'Jodi Benson', 4, 'Lala Doo-Da');
INSERT INTO actors VALUES (100, 6, 'Alex Cazares', 5, 'Staci');
INSERT INTO actors VALUES (101, 21, 'Viktor Horinyak', 1, 'Ivan');
INSERT INTO actors VALUES (102, 21, 'Mila Syvatska', 2, 'Vasilisa');
INSERT INTO actors VALUES (103, 21, 'Ekaterina Vilkova', 3, 'Varvara');
INSERT INTO actors VALUES (104, 21, 'Elena Yakovleva', 4, 'Baba Yaga');
INSERT INTO actors VALUES (105, 21, 'Konstantin Lavronenko', 5, 'Kashchey');
INSERT INTO actors VALUES (106, 22, 'Alessandro Gassmann', 1, 'Santo');
INSERT INTO actors VALUES (107, 22, 'Ginevra Francesconi', 2, 'Sofia');
INSERT INTO actors VALUES (108, 22, 'Remo Girone', 3, 'Remo Girone');
INSERT INTO actors VALUES (109, 22, 'Alessio Praticò', 4, 'Alessio Praticò');
INSERT INTO actors VALUES (110, 22, 'Marcello Mazzarella', 5, 'Marcello Mazzarella');
INSERT INTO actors VALUES (111, 23, 'Benjamin Evan Ainsworth', 1, 'Pinocchio');
INSERT INTO actors VALUES (112, 23, 'Tom Hanks', 2, 'Geppetto');
INSERT INTO actors VALUES (113, 23, 'Joseph Gordon-Levitt', 3, 'Jiminy Cricket');
INSERT INTO actors VALUES (114, 23, 'Luke Evans', 4, 'The Coachman');
INSERT INTO actors VALUES (115, 23, 'Cynthia Erivo', 5, 'Blue Fairy');
INSERT INTO actors VALUES (116, 24, 'Millie Bobby Brown', 1, 'Enola Holmes');
INSERT INTO actors VALUES (117, 24, 'Henry Cavill', 2, 'Sherlock Holmes');
INSERT INTO actors VALUES (118, 24, 'Sam Claflin', 3, 'Mycroft Holmes');
INSERT INTO actors VALUES (119, 24, 'Helena Bonham Carter', 4, 'Eudoria Holmes');
INSERT INTO actors VALUES (120, 24, 'Louis Partridge', 5, 'Lord Tewkesbury');
INSERT INTO actors VALUES (121, 25, 'Millie Bobby Brown', 1, 'Enola Holmes');
INSERT INTO actors VALUES (122, 25, 'Henry Cavill', 2, 'Sherlock Holmes');
INSERT INTO actors VALUES (123, 25, 'Louis Partridge', 3, 'Lord Tewkesbury');
INSERT INTO actors VALUES (124, 25, 'Helena Bonham Carter', 4, 'Eudoria Holmes');
INSERT INTO actors VALUES (125, 25, 'David Thewlis', 5, 'Grall');

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
INSERT INTO movies_themes VALUES (9, 4, 2, 1);
INSERT INTO movies_themes VALUES (10, 4, 6, 2);
INSERT INTO movies_themes VALUES (11, 5, 2, 1);
INSERT INTO movies_themes VALUES (12, 5, 6, 2);
INSERT INTO movies_themes VALUES (13, 6, 1, 1);
INSERT INTO movies_themes VALUES (14, 6, 16, 2);
INSERT INTO movies_themes VALUES (15, 7, 1, 1);
INSERT INTO movies_themes VALUES (16, 7, 2, 2);
INSERT INTO movies_themes VALUES (17, 7, 17, 3);
INSERT INTO movies_themes VALUES (18, 7, 16, 4);
INSERT INTO movies_themes VALUES (19, 8, 1, 1);
INSERT INTO movies_themes VALUES (20, 8, 2, 2);
INSERT INTO movies_themes VALUES (21, 8, 17, 3);
INSERT INTO movies_themes VALUES (22, 8, 16, 4);
INSERT INTO movies_themes VALUES (23, 9, 16, 1);
INSERT INTO movies_themes VALUES (24, 9, 1, 2);
INSERT INTO movies_themes VALUES (25, 9, 2, 3);
INSERT INTO movies_themes VALUES (26, 10, 1, 1);
INSERT INTO movies_themes VALUES (27, 10, 17, 2);
INSERT INTO movies_themes VALUES (28, 10, 16, 3);
INSERT INTO movies_themes VALUES (29, 11, 1, 1);
INSERT INTO movies_themes VALUES (30, 11, 17, 2);
INSERT INTO movies_themes VALUES (31, 12, 9, 1);
INSERT INTO movies_themes VALUES (32, 12, 15, 2);
INSERT INTO movies_themes VALUES (33, 13, 18, 1);
INSERT INTO movies_themes VALUES (34, 14, 3, 1);
INSERT INTO movies_themes VALUES (35, 14, 6, 2);
INSERT INTO movies_themes VALUES (36, 14, 11, 3);
INSERT INTO movies_themes VALUES (37, 14, 2, 4);
INSERT INTO movies_themes VALUES (38, 15, 3, 1);
INSERT INTO movies_themes VALUES (39, 15, 6, 2);
INSERT INTO movies_themes VALUES (40, 15, 11, 3);
INSERT INTO movies_themes VALUES (41, 15, 2, 4);
INSERT INTO movies_themes VALUES (42, 16, 11, 1);
INSERT INTO movies_themes VALUES (43, 16, 2, 2);
INSERT INTO movies_themes VALUES (44, 16, 3, 3);
INSERT INTO movies_themes VALUES (45, 16, 6, 4);
INSERT INTO movies_themes VALUES (46, 17, 6, 1);
INSERT INTO movies_themes VALUES (47, 17, 2, 2);
INSERT INTO movies_themes VALUES (48, 17, 11, 3);
INSERT INTO movies_themes VALUES (49, 17, 3, 4);
INSERT INTO movies_themes VALUES (50, 18, 1, 1);
INSERT INTO movies_themes VALUES (51, 18, 2, 2);
INSERT INTO movies_themes VALUES (52, 18, 16, 3);
INSERT INTO movies_themes VALUES (53, 19, 14, 1);
INSERT INTO movies_themes VALUES (54, 20, 3, 1);
INSERT INTO movies_themes VALUES (55, 20, 2, 2);
INSERT INTO movies_themes VALUES (56, 20, 19, 3);
INSERT INTO movies_themes VALUES (57, 21, 11, 1);
INSERT INTO movies_themes VALUES (58, 21, 2, 2);
INSERT INTO movies_themes VALUES (59, 21, 6, 3);
INSERT INTO movies_themes VALUES (60, 22, 1, 1);
INSERT INTO movies_themes VALUES (61, 22, 2, 2);
INSERT INTO movies_themes VALUES (62, 22, 7, 3);
INSERT INTO movies_themes VALUES (63, 23, 11, 1);
INSERT INTO movies_themes VALUES (64, 23, 1, 2);
INSERT INTO movies_themes VALUES (65, 23, 19, 3);
INSERT INTO movies_themes VALUES (67, 24, 1, 1);
INSERT INTO movies_themes VALUES (68, 24, 2, 2);
INSERT INTO movies_themes VALUES (69, 24, 6, 3);
INSERT INTO movies_themes VALUES (70, 24, 7, 4);
INSERT INTO movies_themes VALUES (71, 25, 2, 1);
INSERT INTO movies_themes VALUES (72, 25, 6, 2);
INSERT INTO movies_themes VALUES (73, 25, 7, 3);

/*************************************************************/
/***********************  PREFERENCES  ***********************/
/*************************************************************/

INSERT INTO preferences VALUES (1, 2, 18, 0);
INSERT INTO preferences VALUES (2, 2, 7, 1);

/*************************************************************/
/**************************  SCORES  *************************/
/*************************************************************/

INSERT INTO scores VALUES (1, 2, 13, 3);

/*************************************************************/
/*******************  SUBSCRIBER RENTALS  ********************/
/*************************************************************/

INSERT INTO subscriber_rentals VALUES (1, 1, 2);
INSERT INTO subscriber_rentals VALUES (2, 2, 2);
INSERT INTO subscriber_rentals VALUES (3, 4, 3);
INSERT INTO subscriber_rentals VALUES (4, 5, 3);

/*************************************************************/
/*****************  NON SUBSCRIBER RENTALS  ******************/
/*************************************************************/

INSERT INTO non_subscriber_rentals VALUES (1, 3, 987654);
