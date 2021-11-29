package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.Interface.IEntrepriseService;
import com.ecam.atsnum.model.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/entreprises")
public class EntrepriseController {

    private IEntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(IEntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping(value = "/all")
    public List<Entreprise> getEntreprises() {
        return this.entrepriseService.getAllEntreprises();
    }

    @PostMapping(value = "/create")
    public Entreprise createUser(@RequestBody Entreprise entreprise) {
        return this.entrepriseService.createEntreprise(entreprise);
    }

    @PutMapping()
    public Entreprise updateEntreprise(Entreprise entreprise) {
        return this.entrepriseService.updateEntreprise(entreprise);
    }

    @GetMapping(value = "/{id}")
    public Entreprise getEntrepriseById(@PathVariable(required = true, name = "id") int id) {
        return this.entrepriseService.getEntrepriseById(id);
    }

}
