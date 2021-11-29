package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.CapteurValueBooleanRepository;
import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.CapteurValueBoolean;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CapteurValueBooleanService {

    private CapteurValueBooleanRepository capteurValueBooleanRepository;

    public CapteurValueBooleanService(CapteurValueBooleanRepository capteurValueBooleanRepository){
        this.capteurValueBooleanRepository=capteurValueBooleanRepository;
    }

    public List<CapteurValueBoolean> getLastDateReleveByMachineId(int machineId) {
        LocalDateTime lastReleve = this.capteurValueBooleanRepository.findLastDateReleveByMachineId(machineId, PageRequest.of(0,1));
        return this.capteurValueBooleanRepository.findAllByMachineIdAndDateReleve(machineId, lastReleve);
    }
    public List<CapteurValueBoolean> getAllByMachineId(int machineId) {
        return this.capteurValueBooleanRepository.findAllByMachineId(machineId);
    }

    public List<CapteurValueBoolean> getAllByMachineIdAndEndTime(int machineId, String endTime) {
        return this.capteurValueBooleanRepository.findAllByMachineIdAndDateReleveBefore(machineId, LocalDateTime.parse(endTime));
    }

    public List<CapteurValueBoolean> getAllByMachineIdAndStartTime(int machineId, String startTime) {
        return this.capteurValueBooleanRepository.findAllByMachineIdAndDateReleveAfter(machineId, LocalDateTime.parse(startTime));
    }

    public List<CapteurValueBoolean> getAllByMachineIdAndStartTimeAndEndTime(int machineId, String startTime, String endTime) {
        return this.capteurValueBooleanRepository.findAllByMachineIdAndDateReleveBetween(machineId,LocalDateTime.parse(startTime),LocalDateTime.parse(endTime));
    }

    public List<CapteurValueBoolean> getByMachineIdAndDateReleve(int machineId, LocalDateTime dateReleve) {
        return this.capteurValueBooleanRepository.findAllByMachineIdAndDateReleve(machineId, dateReleve);
    }
}
