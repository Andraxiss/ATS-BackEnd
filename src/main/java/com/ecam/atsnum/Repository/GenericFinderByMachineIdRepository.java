package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface GenericFinderByMachineIdRepository<T> extends JpaRepository<T,Integer> {

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1")
    List<T> findAllByMachineId(int machineId);

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1 " +
            "and value.releveInformation.dateReleve>=?2")
    List<T> findAllByMachineIdAndStartTime(int machineId, LocalDateTime startTime);

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1 " +
            "and value.releveInformation.dateReleve<?2")
    List<T> findAllByMachineIdAndEndTime(int machineId, LocalDateTime endTime);

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1 " +
            "and value.releveInformation.dateReleve>=?2 and value.releveInformation.dateReleve<?3")
    List<T> findAllByMachineIdAndStartTimeAndEndTime(int machineId, LocalDateTime startTime, LocalDateTime endTime);
}
