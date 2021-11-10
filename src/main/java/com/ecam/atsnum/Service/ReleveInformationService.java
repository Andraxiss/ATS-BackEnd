package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.ReleveInformationRepository;
import com.ecam.atsnum.model.ReleveInformation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleveInformationService {

    private ReleveInformationRepository releveInformationRepository;

    public ReleveInformationService(ReleveInformationRepository releveInformationRepository) {
        this.releveInformationRepository = releveInformationRepository;
    }


    public List<ReleveInformation> getAllReleveInformation() {
        return this.releveInformationRepository.findAll();
    }
}
