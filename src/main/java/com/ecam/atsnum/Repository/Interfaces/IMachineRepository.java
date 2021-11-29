package com.ecam.atsnum.Repository.Interfaces;

import com.ecam.atsnum.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMachineRepository extends JpaRepository<Machine, Integer> {

    Machine findOneByMachineId(int id);
}
