package com.stan.appsecurity.dto.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class AuthenticationResponse {
    private String token;
    private String refreshToken;
}
