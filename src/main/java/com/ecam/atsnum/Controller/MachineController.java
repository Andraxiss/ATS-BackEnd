package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.MachineService;
import com.ecam.atsnum.Service.Interface.IMachineService;
import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.Machine;
import com.ecam.atsnum.model.DTO.MachineDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bo/machines")
public class MachineController {

    private IMachineService machineService;

    @Autowired
    public MachineController(IMachineService machineService) {
        this.machineService = machineService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/all")
    public List<MachineDto> getMachines() {
        List<Machine> machines = this.machineService.getAllMachines();
        List<MachineDto> machinesDto = MachineDto.machineToDtoList(machines);
        return machinesDto;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create")
    public Machine createUser(@RequestBody Machine machine) {
        return this.machineService.createMachine(machine);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public MachineDto updateMachine(@RequestBody MachineDto machineDto) {
        Machine machine = MachineDto.machineFromDto(machineDto);
        Machine machineUpdated = machineService.updateMachine(machine);
        return MachineDto.machineToDto(machineUpdated);
    }

    @GetMapping(value = "/{id}")
    public Machine getEntrepriseById(@PathVariable(required = true, name = "id") int id) {
        return this.machineService.getMachineById(id);
    }

}
