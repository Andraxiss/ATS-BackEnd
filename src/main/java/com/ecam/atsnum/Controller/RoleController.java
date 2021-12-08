package com.ecam.atsnum.Controller;

import com.ecam.atsnum.Configs.TokenProvider;
import com.ecam.atsnum.Service.UserService;
import com.ecam.atsnum.Service.Interface.IRoleService;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.Role;
import com.ecam.atsnum.model.User;
import com.ecam.atsnum.model.DTO.AuthTokenDto;
import com.ecam.atsnum.model.DTO.LoginUserDto;
import com.ecam.atsnum.model.DTO.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/roles")
public class RoleController {

    private IRoleService roleService;

    @Autowired
    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value="/all")
    public List<Role> getAllRoles() {
        return this.roleService.getAllRole();
    }

}
