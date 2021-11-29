package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Service.CapteurValueService;
import com.ecam.atsnum.model.Capteur;
import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.DTO.CapteurHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/bi/capteurs-values")
public class CapteurValueController {

    private CapteurValueService capteurValueService;

    @Autowired
    public CapteurValueController(CapteurValueService capteurValueService) {
        this.capteurValueService = capteurValueService;
    }

    @GetMapping(path = "/machines/{machineId}/capteurs/{capteurId}/history")
    public List<CapteurHistoryDTO> getAllByMachineId(
            @PathVariable("machineId") int machineId,
            @PathVariable("capteurId") int capteurId,
            @RequestParam(name = "startTime", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    LocalDateTime startTime,
            @RequestParam(name = "endTime", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    LocalDateTime endTime) {

        if (startTime != null && endTime != null) {
            List<CapteurValue> capteurValueList =
                    this.capteurValueService.getAllByMachineIdAndCapteurIdAndStartTimeAndEndTime(
                            machineId, capteurId, startTime, endTime);
            return this.capteurValueListToCapteurHistoriqueDTO(capteurValueList);
        } else if (startTime == null && endTime != null) {
            List<CapteurValue> capteurValueList =
                    this.capteurValueService.getAllByMachineIdAndCapteurIdAndEndTime(
                            machineId, capteurId, endTime);
            return this.capteurValueListToCapteurHistoriqueDTO(capteurValueList);
        } else if (startTime != null && endTime == null) {
            List<CapteurValue> capteurValueList =
                    this.capteurValueService.getAllByMachineIdAndCapteurIdAndStartTime(
                            machineId, capteurId, startTime);
            return this.capteurValueListToCapteurHistoriqueDTO(capteurValueList);
        } else {
            List<CapteurValue> capteurValueList =
                    this.capteurValueService.getAllByMachineIdAndCapteurId(machineId, capteurId);
            return this.capteurValueListToCapteurHistoriqueDTO(capteurValueList);
        }
    }

    @GetMapping(path = "/machines/{machineId}")
    public List<CapteurValue> getAllByMachineIdAndDate(@PathVariable("machineId") int machineId,
                                                       @RequestParam(name = "dateReleve", required = false)
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateReleve) {
        return this.capteurValueService.getByMachineIdAndDateReleve(machineId, dateReleve);
    }

    @GetMapping(path = "/machines/{machineId}/last-values")
    public List<CapteurValue> getAllByMachineId(@PathVariable("machineId") int machineId) {
        return this.capteurValueService.getLastReleveByMachineId(machineId);
    }

    @GetMapping(path = "/machines/{machineId}/available")
    public List<Capteur> getAllCapteurByMachineId(@PathVariable("machineId") int machineId) {
        return this.capteurValueService.getAllCapteurByMachineId(machineId);
    }

    private List<CapteurHistoryDTO> capteurValueListToCapteurHistoriqueDTO(
            List<CapteurValue> capteurValueList) {
        List<CapteurHistoryDTO> capteurHistoryDTOList = new ArrayList<>();
        for (CapteurValue cv : capteurValueList) {
            capteurHistoryDTOList.add(
                    new CapteurHistoryDTO(
                            cv.getCapteurValueId(),
                            cv.getCapteurValue(),
                            cv.getMachineId(),
                            cv.getCapteur().getCapteurId(),
                            cv.getDateReleve(),
                            cv.getCapteur().getCapteurNom()));
        }
        return capteurHistoryDTOList;
    }
}
