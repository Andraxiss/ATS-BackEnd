package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.TemperatureService;
import com.ecam.atsnum.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/bi/temperatures")
public class TemperatureController {

    private TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public List<Temperature> getAllTemperatures(){
        return this.temperatureService.getAllTemperatures();
    }

    @GetMapping(path = "/{machineId}")
    public List<Temperature> getAllTemperaturesByMachineId(@PathVariable("machineId") int machineId,
                                                           @RequestParam(name = "startTime", required = false) String startTime,
                                                           @RequestParam(name = "endTime", required = false) String endTime){
        if (startTime!=null && endTime!=null){
            return this.temperatureService.getAllTemperaturesByMachineIdAndStartTimeAndEndTime(machineId, startTime, endTime);
        } else if (startTime==null && endTime!=null) {
            return this.temperatureService.getAllTemperaturesByMachineIdAndEndTime(machineId, endTime);
        } else if (startTime!=null && endTime==null) {
            System.out.println("coucou");
            return this.temperatureService.getAllTemperaturesByMachineIdAndStartTime(machineId, startTime);
        } else {
      System.out.println("je ne suis pas au bon endroit");
            return this.temperatureService.getAllTemperaturesByMachineId(machineId);
        }


    }


}
