package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.ReleveInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleveInformationRepository extends JpaRepository<ReleveInformation, Integer> {
}
