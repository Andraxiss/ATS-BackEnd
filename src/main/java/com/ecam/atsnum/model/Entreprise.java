package com.ecam.atsnum.model;

import org.springframework.lang.NonNull;
import lombok.Data;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "entreprise")
public class Entreprise {
    public Entreprise() {
    }

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entreprise_id")
    private int entrepriseId;
    private String nom;
    private String adresse;
    private String siret;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entreprise")
    @JsonIgnoreProperties(value={ "capteurValues", "entreprise","users" }, allowSetters=true)
    private List<Machine> machines;

    @OneToMany(mappedBy = "entreprise")
    @JsonIgnoreProperties(value="machines", allowSetters = true)
    private List<User> users;

}
