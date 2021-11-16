package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.CapteurRepository;
import com.ecam.atsnum.Repository.CapteurValueRepository;
import com.ecam.atsnum.model.Capteur;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CapteurValueService {

    private CapteurValueRepository capteurValueRepository;

    public CapteurValueService(CapteurValueRepository capteurValueRepository){
        this.capteurValueRepository=capteurValueRepository;
    }


    public List<CapteurValue> getAllByMachineId(int machineId) {
        return this.capteurValueRepository.findAllByMachineId(machineId);
    }

    public List<CapteurValue> getAllByMachineIdAndEndTime(int machineId, String endTime) {
        return this.capteurValueRepository.findAllByMachineIdAndDateReleveBefore(machineId, LocalDateTime.parse(endTime));
    }

    public List<CapteurValue> getAllByMachineIdAndStartTime(int machineId, String startTime) {
        return this.capteurValueRepository.findAllByMachineIdAndDateReleveAfter(machineId, LocalDateTime.parse(startTime));
    }

    public List<CapteurValue> getAllByMachineIdAndStartTimeAndEndTime(int machineId, String startTime, String endTime) {
        return this.capteurValueRepository.findAllByMachineIdAndDateReleveBetween(machineId,LocalDateTime.parse(startTime),LocalDateTime.parse(endTime));
    }
}
