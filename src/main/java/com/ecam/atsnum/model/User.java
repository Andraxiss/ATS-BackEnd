package com.ecam.atsnum.model;

import org.springframework.lang.NonNull;

import lombok.Data;

import java.util.Set;

import javax.persistence.*;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {
            @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private Set<Role> roles;

}
