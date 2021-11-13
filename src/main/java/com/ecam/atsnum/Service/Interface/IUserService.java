package com.ecam.atsnum.Service.Interface;

import java.util.List;

import com.ecam.atsnum.model.User;
import com.ecam.atsnum.model.DTO.UserDto;

public interface IUserService {

    List<User> getAllUser();

    User createUser(UserDto user);
}
