package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.Interfaces.IRoleRepository;
import com.ecam.atsnum.Service.Interface.IRoleService;
import com.ecam.atsnum.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    private IRoleRepository roleRepository;
    
    @Autowired
    public RoleService(IRoleRepository _roleRepository) {
        this.roleRepository = _roleRepository;
    }

    public Role getByName(String name) {
        return this.roleRepository.findRoleByNom(name);
    }
    
}
