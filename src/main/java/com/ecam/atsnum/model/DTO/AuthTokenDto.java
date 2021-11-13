package com.ecam.atsnum.model.DTO;

import lombok.Data;

@Data
public class AuthTokenDto {

    public AuthTokenDto(String token) {
        this.token = token;
    }

    private String token;
}
