package com.ecam.atsnum.Service.Interface;

import com.ecam.atsnum.model.Role;

public interface IRoleService {
    Role getByName(String name);
}
