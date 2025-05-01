package com.stan.appsecurity.dto.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
