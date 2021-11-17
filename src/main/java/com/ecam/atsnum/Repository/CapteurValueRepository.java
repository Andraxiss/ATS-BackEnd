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



    @Query(value = "select DISTINCT capteurValue.dateReleve from CapteurValue capteurValue " +
            "WHERE capteurValue.machineId=?1 ORDER BY capteurValue.dateReleve DESC ")
    public LocalDateTime findLastDateReleveByMachineId(int machineId, PageRequest pageRequest);

    @Query(value = "select capteurValue from CapteurValue capteurValue where capteurValue.machineId=?1 AND capteurValue.capteur.capteurId=?2")
    public List<CapteurValue> findAllByMachineIdAndCapteurId(int machineId, int capteurId);


    public List<CapteurValue> findAllByMachineIdAndDateReleve(int machineId, LocalDateTime dateReleve);

    @Query(value = "select capteurValue from CapteurValue capteurValue " +
            "where capteurValue.machineId=?1 AND capteurValue.capteur.capteurId=?2 " +
            "and capteurValue.dateReleve<?3")
    public List<CapteurValue> findAllByMachineIdAndCapteurIdAndDateReleveBefore(int machineId,int capteurId, LocalDateTime endDate);

    @Query(value = "select capteurValue from CapteurValue capteurValue " +
            "where capteurValue.machineId=?1 AND capteurValue.capteur.capteurId=?2 " +
            "and capteurValue.dateReleve>=?3")
    public List<CapteurValue> findAllByMachineIdAndCapteurIdAndDateReleveAfter(int machineId, int capteurId, LocalDateTime startDate);

    @Query(value = "select capteurValue from CapteurValue capteurValue " +
            "where capteurValue.machineId=?1 AND capteurValue.capteur.capteurId=?2 " +
            "and capteurValue.dateReleve>=?3 and capteurValue.dateReleve<?4")
    public List<CapteurValue> findAllByMachineIdAndCapteurIdAndDateReleveBetween(int machineId, int capteurId, LocalDateTime startDate, LocalDateTime endDate);
}
