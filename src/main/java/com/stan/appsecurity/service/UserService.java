package com.stan.appsecurity.service;

import com.stan.appsecurity.dto.request.ChangePasswordRequest;
import com.stan.appsecurity.dto.request.LoginRequest;
import com.stan.appsecurity.dto.request.RegisterUserRequest;
import com.stan.appsecurity.dto.response.AuthenticationResponse;
import com.stan.appsecurity.dto.response.ChangePasswordResponse;
import com.stan.appsecurity.dto.response.DefaultResponse;
import com.stan.appsecurity.dto.response.RegisterUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    public UserDetailsService userDetailsService();
}
