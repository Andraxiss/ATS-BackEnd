package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.ReleveInformationService;
import com.ecam.atsnum.model.ReleveInformation;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bi/releveinformation")
public class ReleveInformationController {

    private ReleveInformationService releveInformationService;

    public ReleveInformationController(ReleveInformationService releveInformationService) {
        this.releveInformationService = releveInformationService;
    }

    @GetMapping
    public List<ReleveInformation> getReleveInformation(){
        return this.releveInformationService.getAllReleveInformation();
    }
}
