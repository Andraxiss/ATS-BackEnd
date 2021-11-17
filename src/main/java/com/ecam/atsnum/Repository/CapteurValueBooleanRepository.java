package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.CapteurValueBoolean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CapteurValueBooleanRepository extends JpaRepository<CapteurValueBoolean, Integer> {

    public List<CapteurValueBoolean> findAllByMachineId(int machineId);

    @Query(value = "select DISTINCT capteurValueBoolean.dateReleve from CapteurValueBoolean capteurValueBoolean " +
            "WHERE capteurValueBoolean.machineId=?1 ORDER BY capteurValueBoolean.dateReleve DESC ")
    public LocalDateTime findLastDateReleveByMachineId(int machineId, PageRequest pageRequest);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleve(int machineId, LocalDateTime dateReleve);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleveBefore(int machineId, LocalDateTime endDate);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleveAfter(int machineId, LocalDateTime startDate);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleveBetween(int machineId, LocalDateTime startDate, LocalDateTime endDate);
}
