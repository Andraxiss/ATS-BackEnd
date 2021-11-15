package com.ecam.atsnum.model.DTO;

import com.ecam.atsnum.model.User;

import lombok.Data;
@Data
public class AuthTokenDto {

    public AuthTokenDto(String token, User user) {
        this.token = token;
        this.user = user;
    }

    private String token;
    private User user;
}
