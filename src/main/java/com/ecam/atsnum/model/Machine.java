package com.ecam.atsnum.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

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
}
