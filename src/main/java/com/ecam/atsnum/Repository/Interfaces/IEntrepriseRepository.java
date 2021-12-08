package com.ecam.atsnum.Repository.Interfaces;

import com.ecam.atsnum.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    Entreprise findOneByEntrepriseId(int id);
}
