package com.stan.appsecurity.mapper;

import com.stan.appsecurity.config.SecurityConfiguration;
import com.stan.appsecurity.dto.request.RegisterUserRequest;
import com.stan.appsecurity.dto.response.RegisterUserResponse;
import com.stan.appsecurity.entity.AppUsers;
import com.stan.appsecurity.enums.Roles;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Data
@Component
public class UserMapper {

    private final SecurityConfiguration appSecurityConfig;

    public AppUsers mapRegisterUserRequestToAppUser(RegisterUserRequest request){
        log.info("inside mapRegisterUserRequestToAppUser");
        AppUsers appUser = new AppUsers();
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        appUser.setEmail(request.getEmail());
        appUser.setPassword(appSecurityConfig.passwordEncoder().encode(request.getPassword()));
        appUser.setRole(Roles.USER);
        return appUser;
    }

    public RegisterUserResponse mapAppUserToRegisterUserResponse(AppUsers request){
        log.info("inside mapAppUserToRegisterUserResponse");
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setFirstName(request.getFirstName());
        registerUserResponse.setLastName(request.getLastName());
        registerUserResponse.setPassword(request.getPassword());
        registerUserResponse.setEmail(request.getEmail());
        return registerUserResponse;
    }

    public AppUsers mapRegisterUserRequestToAppAdmin(RegisterUserRequest request){
        log.info("inside mapRegisterUserRequestToAppUser");
        AppUsers appUser = new AppUsers();
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        appUser.setEmail(request.getEmail());
        appUser.setPassword(appSecurityConfig.passwordEncoder().encode(request.getPassword()));
        appUser.setRole(Roles.ADMIN);
        return appUser;
    }

    public RegisterUserResponse mapAppAdminToRegisterUserResponse(AppUsers request){
        log.info("inside mapAppUserToRegisterUserResponse");
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setFirstName(request.getFirstName());
        registerUserResponse.setLastName(request.getLastName());
        registerUserResponse.setPassword(request.getPassword());
        registerUserResponse.setEmail(request.getEmail());
        return registerUserResponse;
    }
}
