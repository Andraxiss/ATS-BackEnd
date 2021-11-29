package com.ecam.atsnum.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class CapteurValue {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "capteur_value_id")
    private int capteurValueId;
    private double capteurValue;
    @ManyToOne()
	@JoinColumn(name="machine_id")
    @JsonIgnoreProperties("capteurValues")
	private Machine machine;
    private LocalDateTime dateReleve;
    @ManyToOne
    @JoinColumn(name = "capteur_id")
    private Capteur capteur;
}
