package com.stan.appsecurity.service.impl;

import com.stan.appsecurity.dto.request.ChangePasswordRequest;
import com.stan.appsecurity.dto.request.LoginRequest;
import com.stan.appsecurity.dto.request.RegisterUserRequest;
import com.stan.appsecurity.dto.response.AuthenticationResponse;
import com.stan.appsecurity.dto.response.ChangePasswordResponse;
import com.stan.appsecurity.dto.response.DefaultResponse;
import com.stan.appsecurity.dto.response.RegisterUserResponse;
import com.stan.appsecurity.entity.AppUsers;
import com.stan.appsecurity.enums.ResponseStatus;
import com.stan.appsecurity.exceptions.NotFoundException;
import com.stan.appsecurity.mapper.UserMapper;
import com.stan.appsecurity.repository.AppUserRepository;
import com.stan.appsecurity.service.AdminService;
import com.stan.appsecurity.service.jwt.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AppUserRepository appUserRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DefaultResponse<RegisterUserResponse> registerUser(RegisterUserRequest request) {
        log.info("inside register user service with request ...{}", request);
        DefaultResponse<RegisterUserResponse> defaultResponse = new DefaultResponse<>();
        defaultResponse.setStatus(ResponseStatus.FAILED.getCode());
        defaultResponse.setMessage(ResponseStatus.FAILED.getMessage());

        if (request.getEmail() == null) {
            throw new NotFoundException(ResponseStatus.NOT_FOUND.getCode(), ResponseStatus.NOT_FOUND.getMessage());
        }
        Optional<AppUsers> user = appUserRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            defaultResponse.setMessage("User Already Exist");
            return defaultResponse;
        }
        AppUsers appUser = userMapper.mapRegisterUserRequestToAppUser(request);
        appUserRepository.save(appUser);

        //TODOs: notify user and send token

        defaultResponse.setStatus(ResponseStatus.SUCCESS.getCode());
        defaultResponse.setMessage(ResponseStatus.SUCCESS.getMessage());
        defaultResponse.setData(userMapper.mapAppUserToRegisterUserResponse(appUser));
        return defaultResponse;
    }

    @Override
    public DefaultResponse<AuthenticationResponse> loginUser(LoginRequest request) {
        DefaultResponse<AuthenticationResponse> defaultResponse = new DefaultResponse<>();
        defaultResponse.setStatus(ResponseStatus.FAILED.getCode());
        defaultResponse.setMessage(ResponseStatus.FAILED.getMessage());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<String, String>(), userDetails);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        authenticationResponse.setRefreshToken(refreshToken);

        defaultResponse.setStatus(ResponseStatus.SUCCESS.getCode());
        defaultResponse.setMessage(ResponseStatus.SUCCESS.getMessage());
        defaultResponse.setData(authenticationResponse);

        return defaultResponse;
    }

    @Override
    public DefaultResponse<ChangePasswordResponse> changePassword(ChangePasswordRequest request) {
        DefaultResponse<ChangePasswordResponse> response = new DefaultResponse<>();
        if (StringUtils.isBlank(request.getEmail())) {
            response.setStatus(ResponseStatus.FAILED.getCode());
            response.setMessage("User email is empty");
            return response;
        }
        String email = request.getEmail();
        AppUsers appUser = appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        if (!passwordEncoder.matches(request.getOldPassword(), appUser.getPassword())) {
            response.setStatus(ResponseStatus.FAILED.getCode());
            response.setMessage("Password does not match");
            return response;
        }
        appUser.setPassword(passwordEncoder.encode(request.getNewPassword()));
        appUserRepository.save(appUser);

        response.setStatus(ResponseStatus.SUCCESS.getCode());
        response.setMessage("Password changed successfully");

        return response;

    }
}
