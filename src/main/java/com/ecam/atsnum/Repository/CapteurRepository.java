package com.ecam.atsnum.Repository;

import com.ecam.atsnum.model.Capteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapteurRepository extends JpaRepository<Capteur, Integer> {
}
