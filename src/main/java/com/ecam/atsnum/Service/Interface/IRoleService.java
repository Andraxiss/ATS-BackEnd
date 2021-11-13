package com.ecam.atsnum.Service.Interface;

import com.ecam.atsnum.model.Role;

import org.springframework.stereotype.Component;

@Component
public interface IRoleService {
    Role getByName(String name);
}
