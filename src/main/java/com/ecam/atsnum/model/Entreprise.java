package com.ecam.atsnum.model;

import org.springframework.lang.NonNull;
import lombok.Data;
import java.util.List;
import javax.persistence.*;


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

    @OneToMany( orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "machine_id")
	List<Machine> machines;
}
