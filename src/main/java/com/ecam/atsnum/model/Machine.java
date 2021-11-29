package com.ecam.atsnum.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@Entity
@Table(name = "machine")
public class Machine {

    @Id
    @NonNull
    @Column(name = "machine_id")
    private int machineId;
    private String nom;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "capteur_value_id")
    List<CapteurValue> capteurValues;
}
