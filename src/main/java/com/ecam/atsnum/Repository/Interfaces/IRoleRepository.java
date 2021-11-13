package com.ecam.atsnum.Repository.Interfaces;

import com.ecam.atsnum.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByNom(String name);
}
