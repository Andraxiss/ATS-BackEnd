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

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    @JsonIgnoreProperties(value="machines", allowSetters = true)
    private Entreprise entreprise;

    @ManyToMany(mappedBy = "machines")
    private List<User> users;

}
