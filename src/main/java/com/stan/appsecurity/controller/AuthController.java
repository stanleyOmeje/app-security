package com.stan.appsecurity.controller;


import com.stan.appsecurity.dto.request.LoginRequest;
import com.stan.appsecurity.dto.request.RegisterUserRequest;
import com.stan.appsecurity.dto.response.AuthenticationResponse;
import com.stan.appsecurity.dto.response.DefaultResponse;
import com.stan.appsecurity.dto.response.RegisterUserResponse;
import com.stan.appsecurity.enums.ResponseStatus;
import com.stan.appsecurity.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AdminService adminService;
    @PostMapping("/reg-user")
    public DefaultResponse<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest request) {
        log.info("inside register controller with request ...{}",request);
        return adminService.registerUser(request);
    }

    @PostMapping("/login")
    public DefaultResponse<AuthenticationResponse>  loginUser(@RequestBody LoginRequest request){
        log.info("inside loginUser controller with request ");
        return adminService.loginUser(request);
    }
    @GetMapping("/logon")
    public DefaultResponse<AuthenticationResponse>  logonUser(){
        DefaultResponse<AuthenticationResponse> defaultResponse = new DefaultResponse<AuthenticationResponse>();
        log.info("inside logonUser controller with request ");
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken("77777777777777777777777777");
        response.setRefreshToken("99999999999999999999999");

        defaultResponse.setStatus(ResponseStatus.SUCCESS.getCode());
        defaultResponse.setMessage(ResponseStatus.SUCCESS.getMessage());
        defaultResponse.setData(response);

        return defaultResponse;
    }
}
