package com.ecam.atsnum.model.DTO;

import java.util.ArrayList;
import java.util.List;

import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.Entreprise;
import com.ecam.atsnum.model.Machine;
import com.ecam.atsnum.model.User;

import lombok.Data;

@Data
public class MachineDto {
    private String nom;
    private int machineId;
    private List<CapteurValue> capteurValues;
    private Entreprise entreprise;

    public static MachineDto machineToDto(Machine machine) {
        MachineDto machineDto = new MachineDto();
        machineDto.setNom(machine.getNom());
        machineDto.setMachineId(machine.getMachineId());
        machineDto.setCapteurValues(machine.getCapteurValues());
        machineDto.setEntreprise(machine.getEntreprise());
        return machineDto;
    }

    public static Machine machineFromDto(MachineDto machineDto) {
        Machine machine = new Machine();
        machine.setNom(machineDto.getNom());
        machine.setMachineId(machineDto.getMachineId());
        machine.setCapteurValues(machineDto.getCapteurValues());
        machine.setEntreprise(machineDto.getEntreprise());
        return machine;
    }

    public static List<MachineDto> machineToDtoList(List<Machine> machines) {
        List<MachineDto> machinesDto = new ArrayList<>();
        machines.forEach(machine -> {
            MachineDto machineDto = new MachineDto();
            machineDto.setNom(machine.getNom());
            machineDto.setMachineId(machine.getMachineId());
            machineDto.setEntreprise(machine.getEntreprise());
            machinesDto.add(machineDto);
        });
        return machinesDto;
    }

}
