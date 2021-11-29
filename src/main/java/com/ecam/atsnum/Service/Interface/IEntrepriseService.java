package com.ecam.atsnum.Service.Interface;

import java.util.List;

import com.ecam.atsnum.model.Entreprise;

public interface IEntrepriseService {

    Entreprise getEntrepriseById(int id);

    List<Entreprise> getAllEntreprises();

    Entreprise updateEntreprise(Entreprise entreprise);

    Entreprise createEntreprise(Entreprise entreprise);
    

}
