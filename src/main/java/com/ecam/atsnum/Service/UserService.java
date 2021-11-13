package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.MachineRepository;
import com.ecam.atsnum.Repository.Interfaces.IUserRepository;
import com.ecam.atsnum.Service.Interface.IRoleService;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.Machine;
import com.ecam.atsnum.model.Role;
import com.ecam.atsnum.model.User;
import com.ecam.atsnum.model.DTO.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService, UserDetailsService {

    private IUserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(IUserRepository _userRepository, RoleService _roleService) {
        this.userRepository = _userRepository;
        this.roleService = _roleService;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword_hash(),
                getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNom()));
        });
        return authorities;
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public User createUser(UserDto user) {
        User nUser = user.getUserFromDto();
        nUser.setPassword_hash(bcryptEncoder.encode(user.getPassword_hash()));

        Role role = roleService.getByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if (nUser.getEmail().split("@")[1].equals("admin.edu")) {
            role = roleService.getByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return this.userRepository.save(nUser);
    }
}
