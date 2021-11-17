package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.CapteurValueRepository;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CapteurValueService {

    private CapteurValueRepository capteurValueRepository;

    public CapteurValueService(CapteurValueRepository capteurValueRepository){
        this.capteurValueRepository=capteurValueRepository;
    }

    public List<CapteurValue> getLastReleveByMachineId(int machineId) {
        LocalDateTime lastReleve = this.capteurValueRepository.findLastDateReleveByMachineId(machineId, PageRequest.of(0,1));
        return this.capteurValueRepository.findAllByMachineIdAndDateReleve(machineId, lastReleve);
    }

    public List<CapteurValue> getAllByMachineIdAndCapteurId(int machineId, int capteurId) {
        return this.capteurValueRepository.findAllByMachineIdAndCapteurId(machineId, capteurId);
    }

    public List<CapteurValue> getAllByMachineIdAndCapteurIdAndEndTime(int machineId, int capteurId, String endTime) {
        return this.capteurValueRepository.findAllByMachineIdAndCapteurIdAndDateReleveBefore(machineId, capteurId, LocalDateTime.parse(endTime));
    }

    public List<CapteurValue> getAllByMachineIdAndCapteurIdAndStartTime(int machineId, int capteurId, String startTime) {
        return this.capteurValueRepository.findAllByMachineIdAndCapteurIdAndDateReleveAfter(machineId,capteurId, LocalDateTime.parse(startTime));
    }

    public List<CapteurValue> getAllByMachineIdAndCapteurIdAndStartTimeAndEndTime(int machineId, int capteurId, String startTime, String endTime) {
        return this.capteurValueRepository.findAllByMachineIdAndCapteurIdAndDateReleveBetween(machineId,capteurId,LocalDateTime.parse(startTime),LocalDateTime.parse(endTime));
    }
}
