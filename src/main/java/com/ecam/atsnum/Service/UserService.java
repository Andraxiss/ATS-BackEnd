package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.Interfaces.IUserRepository;
import com.ecam.atsnum.Service.Interface.IRoleService;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.Role;
import com.ecam.atsnum.model.User;
import com.ecam.atsnum.model.DTO.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService, UserDetailsService {

    private IUserRepository userRepository;
    private IRoleService roleService;
    private MailService mailService;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(IUserRepository _userRepository, IRoleService _roleService, MailService _mailService) {
        this.userRepository = _userRepository;
        this.roleService = _roleService;
        this.mailService = _mailService;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword_hash(),
                getAuthority(user));
    }

    public Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNom()));
        });
        return authorities;
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(int id) {
        User user = this.userRepository.findOneByUserId(id);
        return user;
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public User updateUser(User user) {
        User concernedUser = this.userRepository.findOneByUserId(user.getUserId());
        concernedUser = user;
        if(concernedUser.getEntreprise() == null) {
            concernedUser.getMachines().clear();
        }
        return this.userRepository.save(concernedUser);
    }

    public User createUser(UserDto user) {
        User nUser = user.getUserFromDto();
        String uncodePassword = nUser.getPassword_hash();
        nUser.setPassword_hash(bcryptEncoder.encode(user.getPassword_hash()));
        Role role = roleService.getByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        nUser.setRoles(roleSet);
        User userCreated = this.userRepository.save(nUser);
        String email = userCreated.getEmail();
        mailService.sendCredentials(email, uncodePassword);
        return userCreated;
    }

    public User createAdmin(User user) {
        User nUser = user;
        String uncodePassword = user.getPassword_hash();
        nUser.setPassword_hash(bcryptEncoder.encode(user.getPassword_hash()));
        List<Role> role = roleService.getAllRole();
        Set<Role> roleSet = new HashSet<>();
        role.forEach(e -> {
            roleSet.add(e);
        });
        nUser.setRoles(roleSet);
        User userCreated = this.userRepository.save(nUser);
        String email = userCreated.getEmail();
        mailService.sendCredentials(email, uncodePassword);
        return userCreated;
    }
}
