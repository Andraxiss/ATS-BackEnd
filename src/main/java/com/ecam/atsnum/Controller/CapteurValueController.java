package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.CapteurService;
import com.ecam.atsnum.Service.CapteurValueService;
import com.ecam.atsnum.model.Capteur;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bi/capteurs_values")
public class CapteurValueController {


    private CapteurValueService capteurValueService;

    @Autowired
    public CapteurValueController(CapteurValueService capteurValueService){
        this.capteurValueService=capteurValueService;
    }


    @GetMapping(path = "/{machineId}")
    public List<CapteurValue> getAllByMachineId(@PathVariable("machineId") int machineId,
                                                @RequestParam(name = "startTime", required = false) String startTime,
                                                @RequestParam(name = "endTime", required = false) String endTime){

        if (startTime!=null && endTime!=null){
            return this.capteurValueService.getAllByMachineIdAndStartTimeAndEndTime(machineId, startTime, endTime);
        } else if (startTime==null && endTime!=null) {
            return this.capteurValueService.getAllByMachineIdAndEndTime(machineId, endTime);
        } else if (startTime!=null && endTime==null) {
            return this.capteurValueService.getAllByMachineIdAndStartTime(machineId, startTime);
        } else {
            return this.capteurValueService.getAllByMachineId(machineId);
        }
    }
}
