package com.stan.appsecurity.dto.request;

import lombok.Data;

@Data
public class UserSearchCriteria {
    private String firstName;
    private String lastName;
    private String email;
}
