package com.ecam.atsnum.model.DTO;

import java.util.List;

import com.ecam.atsnum.model.Entreprise;
import com.ecam.atsnum.model.Machine;
import com.ecam.atsnum.model.User;

import lombok.Data;

@Data
public class EntrepriseDto {

    private String nom;
    private int entrepriseId;
    private String adresse;
    private String siret;
    private List<User> users;
    private List<Machine> machines;

    public static Entreprise entrepriseFromDto(EntrepriseDto entrepriseDto) {
        Entreprise entreprise = new Entreprise();
        entreprise.setAdresse(entrepriseDto.getAdresse());
        entreprise.setEntrepriseId(entrepriseDto.getEntrepriseId());
        entreprise.setMachines(entrepriseDto.getMachines());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setSiret(entrepriseDto.getSiret());
        entreprise.setUsers(entrepriseDto.getUsers());
        return entreprise;
    }

    public static EntrepriseDto entrepriseToDto(Entreprise entreprise) {
        EntrepriseDto entrepriseDto = new EntrepriseDto();
        entrepriseDto.setAdresse(entreprise.getAdresse());
        entrepriseDto.setEntrepriseId(entreprise.getEntrepriseId());
        entrepriseDto.setMachines(entreprise.getMachines());
        entrepriseDto.setNom(entreprise.getNom());
        entrepriseDto.setSiret(entreprise.getSiret());
        entrepriseDto.setUsers(entreprise.getUsers());
        return entrepriseDto;
    }

}
