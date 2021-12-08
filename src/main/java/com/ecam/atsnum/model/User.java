package com.ecam.atsnum.model;

import org.springframework.lang.NonNull;

import lombok.Data;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.ecam.atsnum.model.DTO.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "user")
public class User {
    public User() {
    }

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String nom;
    private String prenom;
    private String password_hash;
    private String email;
    private String poste;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {
            @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value={"users","capteurValues"})
    @JoinTable(name = "user_machine",
            joinColumns = {
            @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "machine_id") })
    private List<Machine> machines;

    @ManyToOne
    @JoinColumn(name="entreprise_id")
    @JsonIgnoreProperties("users")
    private Entreprise entreprise;

}
