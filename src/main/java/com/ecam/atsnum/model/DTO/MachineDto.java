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
    private Entreprise entreprise;
    private List<User> users;

    public static MachineDto machineToDto(Machine machine) {
        MachineDto machineDto = new MachineDto();
        machineDto.setNom(machine.getNom());
        machineDto.setMachineId(machine.getMachineId());
        machineDto.setEntreprise(machine.getEntreprise());
        machineDto.setUsers(machine.getUsers());
        return machineDto;
    }

    public static Machine machineFromDto(MachineDto machineDto) {
        Machine machine = new Machine();
        machine.setNom(machineDto.getNom());
        machine.setMachineId(machineDto.getMachineId());
        machine.setEntreprise(machineDto.getEntreprise());
        machine.setUsers(machineDto.getUsers());
        return machine;
    }

    public static List<MachineDto> machineToDtoList(List<Machine> machines) {
        List<MachineDto> machinesDto = new ArrayList<>();
        machines.forEach(machine -> {
            MachineDto machineDto = new MachineDto();
            machineDto.setNom(machine.getNom());
            machineDto.setMachineId(machine.getMachineId());
            machineDto.setEntreprise(machine.getEntreprise());
            machineDto.setUsers(machine.getUsers());
            machinesDto.add(machineDto);
        });
        return machinesDto;
    }

}
