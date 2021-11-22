CREATE TABLE IF NOT EXISTS capteur (capteur_id INT AUTO_INCREMENT PRIMARY KEY,
                                    capteur_nom VARCHAR(255),
                                    capteur_type VARCHAR(255),
                                    is_boolean BOOLEAN );

INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_2','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_3','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_4','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_5','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_6','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_7','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_8','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_9','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_10','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_11','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_12','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_13','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_14','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('thermocouple_15','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('tempCombinee','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('tempSeuil_Max','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('tempSeuil_Min','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('tempSeuil_MaxBool','temperature',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('tempSeuil_MinBool','temperature',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('cmdManuTemp','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('consigneTemp','temperature',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('pressionCompresseur','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('pressionAirEntree','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('pressionAirSortie','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('deltaPressionFiltre1_Bool','pression',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('deltaPressionFiltre1_Capt','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('deltaPressionFiltre1_Seuil','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('deltaPressionFiltre2_Bool','pression',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('deltaPressionFiltre2_Capt','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('deltaPressionFiltre2_Seuil','pression',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('consigneHum','humidite',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('humSeuil_Max','humidite',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('humSeuil_Min','humidite',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('humSeuil_MaxBool','humidite',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('humSeuil_MinBool','humidite',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('intensiteCompresseur','humidite',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('debitCompresseur','humidite',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('humCombinee','humidite',false);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('manuAuto','autre',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('modeAutoIn','autre',true);
INSERT INTO capteur(capteur_nom, capteur_type,is_boolean) VALUES ('cmdManuHum','autre',false);