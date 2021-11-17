package com.ecam.atsnum.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Capteur {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int capteurId;
    private String capteurNom;
    private String capteurType;
    private boolean isBoolean;

}
