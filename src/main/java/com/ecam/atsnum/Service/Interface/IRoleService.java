package com.ecam.atsnum.Service.Interface;

import java.util.List;

import com.ecam.atsnum.model.Role;

public interface IRoleService {
    Role getByName(String name);

    List<Role> getAllRole();
}
