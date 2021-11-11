package com.ecam.atsnum.model;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @NonNull
    @Column(name = "user_id")
    private int userId;
    private String nom;
    private String prenom;
    private String password_hash;

}
