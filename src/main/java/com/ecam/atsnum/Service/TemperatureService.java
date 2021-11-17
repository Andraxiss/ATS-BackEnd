package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.TemperatureRepository;
import com.ecam.atsnum.model.Temperature;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemperatureService {

    private TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public List<Temperature> getAllTemperatures() {
        return this.temperatureRepository.findAll();
    }

    public List<Temperature> getAllTemperaturesByMachineId(int machineId) {
        return this.temperatureRepository.findAllByMachineId(machineId);
    }

    public List<Temperature> getAllTemperaturesByMachineIdAndStartTime(int machineId, String startTime) {

        return this.temperatureRepository.findAllByMachineIdAndStartTime(machineId,LocalDateTime.parse(startTime));
    }

    public List<Temperature> getAllTemperaturesByMachineIdAndStartTimeAndEndTime(int machineId, String startTime, String endTime) {
        return this.temperatureRepository.findAllByMachineIdAndStartTimeAndEndTime(machineId,LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));
    }

    public List<Temperature> getAllTemperaturesByMachineIdAndEndTime(int machineId, String endTime) {
        return this.temperatureRepository.findAllByMachineIdAndEndTime(machineId, LocalDateTime.parse(endTime));
    }
}
