CREATE TABLE releve_information (
  releve_information_id int NOT NULL AUTO_INCREMENT,
  machine_id int NOT NULL,
  date_releve TIMESTAMP,
  PRIMARY KEY (releve_information_id),
  FOREIGN KEY (machine_id) REFERENCES machine(machine_id)
);


CREATE TABLE temperatures (
    temperatures_id int NOT NULL AUTO_INCREMENT,
    releve_info_id int NOT NULL,
    PRIMARY KEY (temperatures_id),
    FOREIGN KEY (releve_info_id) REFERENCES releve_information(releve_information_id)
);

CREATE TABLE humidites
(
    humidites_id INT NOT NULL AUTO_INCREMENT,
    releve_info_id int NOT NULL,
    PRIMARY KEY (humidites_id),
    FOREIGN KEY (releve_info_id) REFERENCES releve_information(releve_information_id)
);

CREATE TABLE debits
(
    debits_id INT NOT NULL AUTO_INCREMENT,
    releve_info_id int NOT NULL,
    PRIMARY KEY (debits_id),
    FOREIGN KEY (releve_info_id) REFERENCES releve_information(releve_information_id)
);

CREATE TABLE  capteurs_value
(
    capteurs_value_id INT NOT NULL AUTO_INCREMENT,
    releve_info_id int NOT NULL,
    PRIMARY KEY (capteurs_value_id),
    FOREIGN KEY (releve_info_id) REFERENCES releve_information(releve_information_id)
);

CREATE TABLE capteurs
(
    capteurs_id INT NOT NULL AUTO_INCREMENT,
    releve_info_id INT NOT NULL,
    PRIMARY KEY (capteurs_id),
    FOREIGN KEY (releve_info_id) REFERENCES releve_information(releve_information_id)
);