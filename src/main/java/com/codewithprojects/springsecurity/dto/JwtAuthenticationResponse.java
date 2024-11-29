package com.codewithprojects.springsecurity.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;

    private String refreshToken;

    public void setToken(String jwt) {
    }

    public void setRefreshToken(String refreshToken) {
    }
}
