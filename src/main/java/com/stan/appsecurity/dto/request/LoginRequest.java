package com.stan.appsecurity.dto.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class LoginRequest {
    private String username;
    private String password;
}
