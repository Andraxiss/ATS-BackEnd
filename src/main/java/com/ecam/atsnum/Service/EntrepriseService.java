package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.Interfaces.IEntrepriseRepository;
import com.ecam.atsnum.Service.Interface.IEntrepriseService;
import com.ecam.atsnum.model.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntrepriseService implements IEntrepriseService {

    private IEntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseService(IEntrepriseRepository _entrepriseRepository) {
        this.entrepriseRepository = _entrepriseRepository;
    }

    public Entreprise getEntrepriseById(int id){
        return this.entrepriseRepository.findOneByEntrepriseId(id);
    }

    public List<Entreprise> getAllEntreprises() {
        return this.entrepriseRepository.findAll();
    }

    public Entreprise updateUser(Entreprise entreprise){
        Entreprise concernedEntreprise = this.entrepriseRepository.findOneByEntrepriseId(entreprise.getEntrepriseId());
        concernedEntreprise = entreprise ;
        return this.entrepriseRepository.save(concernedEntreprise);
    }

    public Entreprise createEntreprise(Entreprise entreprise) {
        return this.entrepriseRepository.save(entreprise);
    }
}
