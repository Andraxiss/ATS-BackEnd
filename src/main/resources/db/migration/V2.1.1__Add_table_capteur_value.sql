CREATE TABLE IF NOT EXISTS capteur_value (capteur_value_id INT AUTO_INCREMENT,
                                     capteur_value double,
                                     capteur_id int,
                                     machine_id int,
                                     date_releve TIMESTAMP,
                                     PRIMARY KEY (capteur_value_id),
                                     FOREIGN KEY (capteur_id) REFERENCES capteur(capteur_id),
                                     FOREIGN KEY (machine_id) REFERENCES machine(machine_id));

CREATE TABLE IF NOT EXISTS capteur_value_boolean (capteur_value_boolean_id INT AUTO_INCREMENT,
                                          capteur_value_boolean_value boolean,
                                          capteur_id int,
                                          machine_id int,
                                          date_releve TIMESTAMP,
                                          PRIMARY KEY (capteur_value_boolean_id),
                                          FOREIGN KEY (capteur_id) REFERENCES capteur(capteur_id),
                                          FOREIGN KEY (machine_id) REFERENCES machine(machine_id));

INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,1,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,2,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,3,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,4,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,5,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,6,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,7,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,8,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,9,'2021-11-16 16:00:00',1);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,1,'2021-11-16 16:00:00',2);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,2,'2021-11-16 16:00:00',2);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,3,'2021-11-16 16:00:00',2);
INSERT INTO capteur_value(capteur_value, capteur_id,date_releve,machine_id) VALUES (10.5,4,'2021-11-16 16:00:00',2);


