package com.ecam.atsnum.model.DTO;

import java.util.ArrayList;
import java.util.List;

import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.Machine;
import com.ecam.atsnum.model.User;

import lombok.Data;

@Data
public class MachineDto {
    private String nom;
    private int machineId;
    private List<CapteurValue> capteurValues;

    public static MachineDto machineToDto(Machine machine) {
        MachineDto machineDto = new MachineDto();
        machineDto.setNom(machine.getNom());
        machineDto.setMachineId(machine.getMachineId());
        machineDto.setCapteurValues(machine.getCapteurValues());
        return machineDto;
    }

    public static List<MachineDto> machineToDtoList(List<Machine> machines) {
        List<MachineDto> machinesDto = new ArrayList<>();
        machines.forEach(machine -> {
            MachineDto machineDto = new MachineDto();
            machineDto.setNom(machine.getNom());
            machineDto.setMachineId(machine.getMachineId());
            machineDto.setCapteurValues(machine.getCapteurValues());
            machinesDto.add(machineDto);
        });
        return machinesDto;
    }

}
