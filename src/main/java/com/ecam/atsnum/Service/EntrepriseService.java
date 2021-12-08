package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.Interfaces.IEntrepriseRepository;
import com.ecam.atsnum.Repository.Interfaces.IMachineRepository;
import com.ecam.atsnum.Service.Interface.IEntrepriseService;
import com.ecam.atsnum.model.Entreprise;
import com.ecam.atsnum.model.Machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService implements IEntrepriseService {

    private IEntrepriseRepository entrepriseRepository;
    private IMachineRepository machineRepository;

    @Autowired
    public EntrepriseService(IEntrepriseRepository _entrepriseRepository, IMachineRepository _machineRepository) {
        this.entrepriseRepository = _entrepriseRepository;
        this.machineRepository = _machineRepository;
    }

    public Entreprise getEntrepriseById(int id) {
        return this.entrepriseRepository.findOneByEntrepriseId(id);
    }

    public List<Entreprise> getAllEntreprises() {

        return this.entrepriseRepository.findAll();
    }

    public Entreprise updateEntreprise(Entreprise entreprise) {
        Entreprise entrepriseToUpdate = this.entrepriseRepository.findOneByEntrepriseId(entreprise.getEntrepriseId());
        entrepriseToUpdate = entreprise;
        return this.entrepriseRepository.save(entrepriseToUpdate);
    }

    public Entreprise createEntreprise(Entreprise entreprise) {
        return this.entrepriseRepository.save(entreprise);
    }
}
