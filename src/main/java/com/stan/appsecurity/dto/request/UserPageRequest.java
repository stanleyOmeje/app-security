package com.stan.appsecurity.dto.request;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class UserPageRequest {
    private int page;
    private int size;
    private Sort.Direction sortDirection = Sort.Direction.DESC;
    private String sortBy = "id";
}
