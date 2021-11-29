CREATE TABLE
IF NOT EXISTS entreprise
(entreprise_id INT AUTO_INCREMENT PRIMARY KEY,
 nom VARCHAR
(255),
 adresse VARCHAR
(255),
 siret VARCHAR
(255)
 );


ALTER TABLE machine
ADD entreprise_id INTEGER
,
ADD CONSTRAINT FOREIGN KEY
(entreprise_id) REFERENCES entreprise
(entreprise_id);

