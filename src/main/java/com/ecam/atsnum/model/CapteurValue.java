package com.ecam.atsnum.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class CapteurValue {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int capteurValueId;
    private double capteurValue;
    private int machineId;
    private LocalDateTime dateReleve;
    @ManyToOne
    @JoinColumn(name = "capteur_id")
    private Capteur capteur;
}
