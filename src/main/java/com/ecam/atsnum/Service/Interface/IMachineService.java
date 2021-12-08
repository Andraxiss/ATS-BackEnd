package com.ecam.atsnum.Service.Interface;

import java.util.List;

import com.ecam.atsnum.model.Machine;

public interface IMachineService {

    Machine getMachineById(int id);

    List<Machine> getAllMachines();

    Machine updateMachine(Machine machine);

    Machine createMachine(Machine machine);
    

}
