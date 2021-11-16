package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.CapteurRepository;
import com.ecam.atsnum.model.Capteur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapteurService {

    private CapteurRepository capteurRepository;

    public CapteurService(CapteurRepository capteurRepository){
        this.capteurRepository=capteurRepository;
    }

    public List<Capteur> getAllCapteur() {
        return this.capteurRepository.findAll();
    }
}
