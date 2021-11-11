package com.ecam.atsnum.Service.Interface;

import java.util.List;

import com.ecam.atsnum.model.User;

public interface IUserService {

    List<User> getAllUser();
    User createUser(User user);
}
