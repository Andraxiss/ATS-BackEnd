package com.ecam.atsnum;

import com.ecam.atsnum.Repository.Interfaces.IUserRepository;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.User;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeederData implements CommandLineRunner {

    private IUserRepository userRepository;
    private IUserService userService;

    @Value("${user.mail}")
    private String mail;

    @Autowired
    public SeederData(IUserRepository _userRepository, IUserService _userService) {
        this.userRepository = _userRepository;
        this.userService = _userService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        User user = userRepository.findByEmail(mail);
        if (user == null) {
            User userToCreate = new User();
            userToCreate.setNom("ATS");
            userToCreate.setPrenom("ADMIN");
            userToCreate.setEmail(mail);
            userToCreate.setPassword_hash(randomPassword());
            userService.createAdmin(userToCreate);
        } 
    }

    private static String randomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random(8, characters);
        return pwd;
    }

}
