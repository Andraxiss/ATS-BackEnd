package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.CapteurService;
import com.ecam.atsnum.Service.CapteurValueService;
import com.ecam.atsnum.model.Capteur;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bi/capteurs")
public class CapteurController {

    private CapteurService capteurService;

    @Autowired
    public CapteurController(CapteurService capteurService){
        this.capteurService=capteurService;
    }

    @GetMapping
    public List<Capteur> getAllCapteur(){
        return this.capteurService.getAllCapteur();
    }

}
