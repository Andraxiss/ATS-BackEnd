CREATE TABLE IF NOT EXISTS capteur_value (capteur_value_id INT AUTO_INCREMENT,
                                     capteur_value double,
                                     capteur_id int,
                                     machine_id int,
                                     date_releve TIMESTAMP,
                                     PRIMARY KEY (capteur_value_id),
                                     FOREIGN KEY (capteur_id) REFERENCES capteur(capteur_id),
                                     FOREIGN KEY (machine_id) REFERENCES machine(machine_id));

CREATE TABLE IF NOT EXISTS capteur_value_boolean (capteur_value_boolean_id INT AUTO_INCREMENT,
                                          capteur_boolean_value boolean,
                                          capteur_id int,
                                          machine_id int,
                                          date_releve TIMESTAMP,
                                          PRIMARY KEY (capteur_value_boolean_id),
                                          FOREIGN KEY (capteur_id) REFERENCES capteur(capteur_id),
                                          FOREIGN KEY (machine_id) REFERENCES machine(machine_id));


