package com.stan.appsecurity.dto.request;


import com.stan.appsecurity.enums.Roles;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ModifyUserRoleRequest {
    private String email;
    private Roles role;
}
