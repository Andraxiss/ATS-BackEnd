package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.CapteurValueBooleanService;
import com.ecam.atsnum.Service.CapteurValueService;
import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.CapteurValueBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/bi/capteurs-values-boolean")
public class CapteurValueBooleanController {


    private CapteurValueBooleanService capteurValueBooleanService;

    @Autowired
    public CapteurValueBooleanController(CapteurValueBooleanService capteurValueBooleanService){
        this.capteurValueBooleanService=capteurValueBooleanService;
    }


    @GetMapping(path = "/{machineId}")
    public List<CapteurValueBoolean> getAllByMachineId(@PathVariable("machineId") int machineId,
                                                       @RequestParam(name = "startTime", required = false) String startTime,
                                                       @RequestParam(name = "endTime", required = false) String endTime){

        if (startTime!=null && endTime!=null){
            return this.capteurValueBooleanService.getAllByMachineIdAndStartTimeAndEndTime(machineId, startTime, endTime);
        } else if (startTime==null && endTime!=null) {
            return this.capteurValueBooleanService.getAllByMachineIdAndEndTime(machineId, endTime);
        } else if (startTime!=null && endTime==null) {
            return this.capteurValueBooleanService.getAllByMachineIdAndStartTime(machineId, startTime);
        } else {
            return this.capteurValueBooleanService.getAllByMachineId(machineId);
        }
    }

    @GetMapping(path = "machines/{machineId}/last-values")
    public List<CapteurValueBoolean> getAllByMachineId(@PathVariable("machineId") int machineId){
        return this.capteurValueBooleanService.getLastDateReleveByMachineId(machineId);
    }

    @GetMapping(path = "/machines/{machineId}")
    public List<CapteurValueBoolean> getAllByMachineIdAndDate(@PathVariable("machineId") int machineId,
                                                       @RequestParam(name = "dateReleve", required = false)
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateReleve) {
        return this.capteurValueBooleanService.getByMachineIdAndDateReleve(machineId, dateReleve);
    }
}
