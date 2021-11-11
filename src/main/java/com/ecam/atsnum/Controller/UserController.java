package com.ecam.atsnum.Controller;
import com.ecam.atsnum.Service.Interface.IUserService;
import com.ecam.atsnum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bo/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return this.userService.getAllUser();
    }
    @PostMapping
    public User createUser(User user){
        return this.userService.createUser(user);
    }

}
