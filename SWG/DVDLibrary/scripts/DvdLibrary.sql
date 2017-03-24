DROP DATABASE IF EXISTS dvdlibrary;

CREATE DATABASE dvdlibrary;

USE dvdlibrary;

CREATE TABLE IF NOT EXISTS `dvds` (
	`lib_id` int NOT NULL auto_increment,
	`title` varchar(80),
	`rating_us` varchar(50),
	`release_date` varchar(4),
	`director_name` varchar(50),
	`studio_name` varchar(50),
	`user_rating` INT(1),
	`user_comment` varchar(200),
	`cover_art` varchar(50),
	PRIMARY KEY(`lib_id`)
);

INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Iron Man','PG-13','2008','Jon Favreau','Marvel Studios','iron-man.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('The Incredible Hulk','PG-13','2008','Louis Leterrier','Marvel Studios','the-incredible-hulk.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Iron Man 2','PG-13','2010','Jon Favreau','Marvel Studios','iron-man-2.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Thor','PG-13','2011','Kenneth Branagh','Marvel Studios','thor.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Captain America: The First Avenger','PG-13','2011','Joe Johnston','Marvel Studios','captain-america-first-avenger.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Marvel\'s The Avengers','PG-13','2012','Joss Whedon','Marvel Studios','marvels-the-avengers.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Iron Man 3','PG-13','2013','Shane Black','Marvel Studios','iron-man-3.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Thor: The Dark World','PG-13','2013','Alan Taylor','Marvel Studios','thor-the-dark-world.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Captain America: The Winter Soldier','PG-13','2014','Anthony and Joe Russo','Marvel Studios','captain-america-winter-soldier.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Guardians of the Galaxy','PG-13','2014','James Gunn','Marvel Studios','guardians-of-the-galaxy.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Avengers: Age of Ultron','PG-13','2015','Joss Whedon','Marvel Studios','avengers-age-of-ultron.jpg',0);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Ant-Man','PG-13','2015','Peyton Reed','Marvel Studios','ant-man.jpg',5);
INSERT INTO `dvdlibrary`.`dvds` (`title`,`rating_us`,`release_date`,`director_name`,`studio_name`,`cover_art`,`user_rating`) VALUES ('Captain America: Civil War','PG-13','2016','Anthony and Joe Russo','Marvel Studios','captain-america-civil-war.jpg',0);
