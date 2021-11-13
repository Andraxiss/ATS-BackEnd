package com.ecam.atsnum.model;

import org.springframework.lang.NonNull;

import lombok.Data;

import java.util.Set;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role {
    public Role() {

    }

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    private String nom;
    private String description;
}
