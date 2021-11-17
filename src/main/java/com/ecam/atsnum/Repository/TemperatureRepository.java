package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TemperatureRepository extends GenericFinderByMachineIdRepository<Temperature>  {

}
