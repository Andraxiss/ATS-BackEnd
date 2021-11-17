package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.CapteurValueService;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/bi/capteurs-values")
public class CapteurValueController {


    private CapteurValueService capteurValueService;

    @Autowired
    public CapteurValueController(CapteurValueService capteurValueService){
        this.capteurValueService=capteurValueService;
    }


    @GetMapping(path = "/{machineId}/{capteurId}")
    public List<CapteurValue> getAllByMachineId(@PathVariable("machineId") int machineId,
                                                @PathVariable("capteurId") int capteurId,
                                                @RequestParam(name = "startTime", required = false) String startTime,
                                                @RequestParam(name = "endTime", required = false) String endTime){

        if (startTime!=null && endTime!=null){
            return this.capteurValueService.getAllByMachineIdAndCapteurIdAndStartTimeAndEndTime(machineId,capteurId, startTime, endTime);
        } else if (startTime==null && endTime!=null) {
            return this.capteurValueService.getAllByMachineIdAndCapteurIdAndEndTime(machineId,capteurId, endTime);
        } else if (startTime!=null && endTime==null) {
            return this.capteurValueService.getAllByMachineIdAndCapteurIdAndStartTime(machineId,capteurId, startTime);
        } else {
            return this.capteurValueService.getAllByMachineIdAndCapteurId(machineId,capteurId);
        }
    }

    @GetMapping(path = "/{machineId}/last-values")
    public List<CapteurValue> getAllByMachineId(@PathVariable("machineId") int machineId){
        return this.capteurValueService.getLastReleveByMachineId(machineId);
    }
}
