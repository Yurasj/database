CREATE DATABASE IF NOT EXISTS netflix1;
USE netflix1;

DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `movie`;
DROP TABLE IF EXISTS `language`;
DROP TABLE IF EXISTS `company`;
DROP TABLE IF EXISTS `award`;
DROP TABLE IF EXISTS `actor`;


CREATE TABLE `movie`(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    company_id BIGINT NOT NULL,
    language_id BIGINT NOT NULL,
    actor_id BIGINT NOT NULL,
    award_id BIGINT,
	name VARCHAR(35) NOT NULL,
    info VARCHAR(1000) NOT NULL
);

CREATE TABLE `language`(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	language VARCHAR(40) NOT NULL
);

CREATE TABLE `review`(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	comment VARCHAR(400) NOT NULL,
    rating INT NOT NULL,
    movie_id BIGINT NOT NULL
);

CREATE TABLE `company`(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(35) NOT NULL,
    info VARCHAR(500) NOT NULL
);

CREATE TABLE `award`(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(35) NOT NULL
);

CREATE TABLE `actor`(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	full_name VARCHAR(80) NOT NULL,
    bio VARCHAR(500) NOT NULL,
    age INT NOT NULL
);


ALTER TABLE `movie`
	ADD INDEX movie_index (id),
    ADD INDEX company_index (company_id),
	ADD CONSTRAINT fk_company
		FOREIGN KEY(company_id) 
		REFERENCES company(id),
	ADD CONSTRAINT fk_language
		FOREIGN KEY(language_id) 
		REFERENCES language(id),
	ADD CONSTRAINT fk_actor
		FOREIGN KEY(actor_id) 
		REFERENCES actor(id),
	ADD CONSTRAINT fk_award
		FOREIGN KEY(award_id) 
		REFERENCES award(id);

ALTER TABLE `review`
	ADD INDEX movie_id_index (movie_id),
    ADD CONSTRAINT fk_movie
		FOREIGN KEY(movie_id) 
		REFERENCES movie(id);

INSERT INTO `language` (language) 
VALUES
	("english"),        
	("german"),        
	("ukrainian"),        
	("spanish"),        
	("chinese"),        
	("hindi");   
    
INSERT INTO `award` (name) 
VALUES
	("oscar2014"),        
	("oscar2015"),        
	("oscar2016"),        
	("oscar2017"),        
	("oscar2018"),        
	("oscar2019"),        
	("oscar2020"),        
	("oscar2021");
    
INSERT INTO `company` (name, info) 
VALUES
	("Marvel", "is an American entertainment company founded in June 1998 and based in New York City, New York, formed by the merger of Marvel Entertainment Group and Toy Biz."), 
	("DC", "is an American comic book publisher and the flagship unit of DC Entertainment,[4][5] a subsidiary of Warner Bros. Discovery."), 
	("DreamWorks", "is an American entertainment company owned by DreamWorks Animation, which is a subsidiary of Universal Pictures and a division of Comcast's NBCUniversal."),
	("Netflix", "Netflix is a multi-billion dollar media-service provider based in Los Gatos, California, USA. The company was founded in 1997 by Reed Hastings and Marc Randolph.");
    
INSERT INTO `actor` (full_name, bio, age) 
VALUES
	("Dwayne Johnson", "is an American actor, producer, businessman, and former professional wrestler.", 50), 
	("Meryl Streep", "Considered by many critics to be the greatest living actress, Meryl Streep has been nominated for the Academy Award an astonishing 21 times, and has won it three times.", 73), 
	("Clark Gable", "William Clark Gable was born on February 1, 1901 in Cadiz, Ohio, to Adeline (Hershelman) and William Henry Gable, an oil-well driller.", 59), 
	("Leonardo DiCaprio", "Few actors in the world have had a career quite as diverse as Leonardo DiCaprio's.", 47), 
	("Morgan Freeman", "With an authoritative voice and calm demeanor, this ever popular American actor has grown into one of the most respected figures in modern US cinema. ", 85);
    
INSERT INTO `movie` (company_id, language_id, actor_id, award_id, name, info) 
VALUES
	(1,1,3,4,"Spider-Man: No Way Home","Spider-Man: No Way Home is a 2021 American superhero film based on the Marvel Comics character Spider-Man, co-produced by Columbia Pictures and Marvel Studios and distributed by Sony Pictures Releasing."),
	(2,3,1,2,"The Batman 2022","The Batman is a 2022 American superhero film based on the DC Comics character Batman."),
	(3,2,5,6,"Puss in Boots","Puss in Boots is a 2011 American computer-animated comedy film[4] produced by DreamWorks Animation and distributed by Paramount Pictures.");
    
INSERT INTO `review` (comment, rating, movie_id) 
VALUES
("cool movie!", 5, 3),    
("bad quality", 2, 2),    
("my fav movie", 5, 2),    
("not my genre(", 3, 1),    
("That is awesome", 5, 1),   
("Love it", 5, 3);    
        