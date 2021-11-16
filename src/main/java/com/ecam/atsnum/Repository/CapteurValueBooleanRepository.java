package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.CapteurValue;
import com.ecam.atsnum.model.CapteurValueBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CapteurValueBooleanRepository extends JpaRepository<CapteurValueBoolean, Integer> {

    public List<CapteurValueBoolean> findAllByMachineId(int machineId);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleveBefore(int machineId, LocalDateTime endDate);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleveAfter(int machineId, LocalDateTime startDate);

    public List<CapteurValueBoolean> findAllByMachineIdAndDateReleveBetween(int machineId, LocalDateTime startDate, LocalDateTime endDate);
}
