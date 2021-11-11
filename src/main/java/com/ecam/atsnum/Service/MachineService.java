package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.MachineRepository;
import com.ecam.atsnum.model.Machine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    private MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> getAllMachine() {
        return this.machineRepository.findAll();
    }
}
