use springdatadb;

TRUNCATE TABLE country;

INSERT INTO country (id, name) VALUES(1,'Brazil');
INSERT INTO country (id, name) VALUES(2,'United States');
INSERT INTO country (id, name) VALUES(3,'France');

TRUNCATE TABLE city;

INSERT INTO city (name, country_id) VALUES('Curitiba',1);
INSERT INTO city (name, country_id) VALUES('Rio de Janeiro',1);
INSERT INTO city (name, country_id) VALUES('Manaus',1);
INSERT INTO city (name, country_id) VALUES('Fortaleza',1);
INSERT INTO city (name, country_id) VALUES('New York',2);
INSERT INTO city (name, country_id) VALUES('Los Angeles',2);
INSERT INTO city (name, country_id) VALUES('Atlanta',2);
INSERT INTO city (name, country_id) VALUES('Paris',3);
INSERT INTO city (name, country_id) VALUES('Lyon',3);

