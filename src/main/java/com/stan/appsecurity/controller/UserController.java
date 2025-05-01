package com.stan.appsecurity.controller;

import com.stan.appsecurity.dto.request.ChangePasswordRequest;
import com.stan.appsecurity.dto.response.ChangePasswordResponse;
import com.stan.appsecurity.dto.response.DefaultResponse;
import com.stan.appsecurity.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final AdminService adminService;

    @PostMapping("change-password")
    DefaultResponse<ChangePasswordResponse> changePassword(@RequestBody ChangePasswordRequest request){
        log.info("inside Change Password controller with request ...{}", request);
        return adminService.changePassword(request);
    }
}
