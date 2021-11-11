package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.MachineService;
import com.ecam.atsnum.model.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bo/machines")
public class MachineController {

    private MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping
    public List<Machine> getMachine(){
        return this.machineService.getAllMachine();
    }

}
