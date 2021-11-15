package com.ecam.atsnum.model.DTO;

import com.ecam.atsnum.model.User;

import lombok.Data;

@Data
public class UserDto {
    private String nom;
    private String password_hash;
    private String email;
    private String prenom;
    private String poste;

    public User getUserFromDto(){
        User user = new User();
        user.setNom(nom);
        user.setPassword_hash(password_hash);
        user.setEmail(email);
        user.setPrenom(prenom);
        user.setPoste(poste);
        return user;
    } 
}
