package com.stan.appsecurity.service;

import com.stan.appsecurity.dto.request.ChangePasswordRequest;
import com.stan.appsecurity.dto.request.LoginRequest;
import com.stan.appsecurity.dto.request.RegisterUserRequest;
import com.stan.appsecurity.dto.response.AuthenticationResponse;
import com.stan.appsecurity.dto.response.ChangePasswordResponse;
import com.stan.appsecurity.dto.response.DefaultResponse;
import com.stan.appsecurity.dto.response.RegisterUserResponse;

public interface AdminService {
    DefaultResponse<RegisterUserResponse> registerUser(RegisterUserRequest request);

    DefaultResponse<AuthenticationResponse> loginUser(LoginRequest request);

    DefaultResponse<ChangePasswordResponse> changePassword(ChangePasswordRequest request);
}
