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
import com.stan.appsecurity.service.UserService;
import com.stan.appsecurity.service.jwt.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final AppUserRepository appUserRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return appUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
            }
        };
    }


}
