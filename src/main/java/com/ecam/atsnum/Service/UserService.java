package com.ecam.atsnum.Service;

import com.ecam.atsnum.Repository.MachineRepository;
import com.ecam.atsnum.Repository.Interfaces.IUserRepository;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.Machine;
import com.ecam.atsnum.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository _userRepository) {
        this.userRepository = _userRepository;
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        user.setPassword_hash(passwordEncoder.encode(user.getPassword_hash()));
        return this.userRepository.save(user);
    }
}
