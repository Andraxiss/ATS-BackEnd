package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.Capteur;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CapteurValueRepository extends JpaRepository<CapteurValue, Integer> {

    public List<CapteurValue> findAllByMachineId(int machineId);

    @Query(value = "select DISTINCT capteurValue.dateReleve from CapteurValue capteurValue " +
            "WHERE capteurValue.machineId=?1 ORDER BY capteurValue.dateReleve DESC ")
    public LocalDateTime findLastDateReleveByMachineId(int machineId, PageRequest pageRequest);

    public List<CapteurValue> findAllByMachineIdAndDateReleve(int machineId, LocalDateTime dateReleve);

    public List<CapteurValue> findAllByMachineIdAndDateReleveBefore(int machineId, LocalDateTime endDate);

    public List<CapteurValue> findAllByMachineIdAndDateReleveAfter(int machineId, LocalDateTime startDate);

    public List<CapteurValue> findAllByMachineIdAndDateReleveBetween(int machineId, LocalDateTime startDate, LocalDateTime endDate);
}
