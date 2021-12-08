package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.Interfaces.IEntrepriseRepository;
import com.ecam.atsnum.Repository.Interfaces.IMachineRepository;
import com.ecam.atsnum.Service.Interface.IEntrepriseService;
import com.ecam.atsnum.Service.Interface.IMachineService;
import com.ecam.atsnum.model.Entreprise;
import com.ecam.atsnum.model.Machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MachineService implements IMachineService {

    private IMachineRepository machineRepository;

    @Autowired
    public MachineService(IMachineRepository _machineRepository) {
        this.machineRepository = _machineRepository;
    }

    public Machine getMachineById(int id) {
        return this.machineRepository.findOneByMachineId(id);
    }

    public List<Machine> getAllMachines() {
        return this.machineRepository.findAll();
    }

    public Machine updateMachine(Machine machine) {
        Machine concernedMachine = this.machineRepository.findOneByMachineId(machine.getMachineId());
        machine.setCapteurValues(concernedMachine.getCapteurValues());
        concernedMachine = machine;
        return this.machineRepository.save(concernedMachine);
    }

    public Machine createMachine(Machine machine) {
        return this.machineRepository.save(machine);
    }
}
