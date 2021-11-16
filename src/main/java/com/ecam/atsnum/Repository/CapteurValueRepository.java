package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.Capteur;
import com.ecam.atsnum.model.CapteurValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CapteurValueRepository extends JpaRepository<CapteurValue, Integer> {

    public List<CapteurValue> findAllByMachineId(int machineId);

    public List<CapteurValue> findAllByMachineIdAndDateReleveBefore(int machineId, LocalDateTime endDate);

    public List<CapteurValue> findAllByMachineIdAndDateReleveAfter(int machineId, LocalDateTime startDate);

    public List<CapteurValue> findAllByMachineIdAndDateReleveBetween(int machineId, LocalDateTime startDate, LocalDateTime endDate);
}
