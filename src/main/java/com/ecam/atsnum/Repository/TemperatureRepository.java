package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature,Integer> {

    @Query(value = "SELECT temp from Temperature temp where temp.releveInformation.machine.machineId=?1")
    List<Temperature> findAllByMachineId(int machineId);

    @Query(value = "SELECT temp from Temperature temp where temp.releveInformation.machine.machineId=?1 " +
            "and temp.releveInformation.dateReleve>=?2")
    List<Temperature> findAllByMachineIdAndStartTime(int machineId, LocalDateTime startTime);

    @Query(value = "SELECT temp from Temperature temp where temp.releveInformation.machine.machineId=?1 " +
            "and temp.releveInformation.dateReleve<?2")
    List<Temperature> findAllByMachineIdAndEndTime(int machineId, LocalDateTime endTime);

    @Query(value = "SELECT temp from Temperature temp where temp.releveInformation.machine.machineId=?1 " +
            "and temp.releveInformation.dateReleve>=?2 and temp.releveInformation.dateReleve<?3")
    List<Temperature> findAllByMachineIdAndStartTimeAndEndTime(int machineId, LocalDateTime startTime, LocalDateTime endTime);

}
