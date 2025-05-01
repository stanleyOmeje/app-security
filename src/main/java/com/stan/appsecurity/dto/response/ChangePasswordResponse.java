package com.stan.appsecurity.dto.response;

import lombok.Data;

@Data
public class ChangePasswordResponse {
    private String code;
    private String message;
}
