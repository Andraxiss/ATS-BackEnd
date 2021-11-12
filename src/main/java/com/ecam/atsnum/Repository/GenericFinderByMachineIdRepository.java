package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.GenericTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;

@NoRepositoryBean
public interface GenericFinderByMachineIdRepository<T extends GenericTableModel> extends JpaRepository<T,Integer> {

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1")
    List<T> findAllByMachineId(int machineId);

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1 " +
            "and value.releveInformation.dateReleve>=?2")
    List<T> findAllByMachineIdAndStartTime(int machineId, LocalDateTime startTime);

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1 " +
            "and value.releveInformation.dateReleve<?2")
    List<T> findAllByMachineIdAndEndTime(int machineId, LocalDateTime endTime);

    @Query(value = "SELECT value from #{#entityName} value where value.releveInformation.machine.machineId=?1 " +
            "and value.releveInformation.dateReleve between ?2 and ?3")
    List<T> findAllByMachineIdAndStartTimeAndEndTime(int machineId, LocalDateTime startTime, LocalDateTime endTime);
}
