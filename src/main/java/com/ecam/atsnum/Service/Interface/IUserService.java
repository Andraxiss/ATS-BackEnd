package com.ecam.atsnum.Service.Interface;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ecam.atsnum.model.User;
import com.ecam.atsnum.model.DTO.UserDto;

public interface IUserService {

    List<User> getAllUser();

    User createUser(UserDto user);

    User createAdmin(User user);

    Set<SimpleGrantedAuthority> getAuthority(User user);

    User getUserByEmail(String email);
    
    User updateUser(User user);

    User getUserById(int id);
}
