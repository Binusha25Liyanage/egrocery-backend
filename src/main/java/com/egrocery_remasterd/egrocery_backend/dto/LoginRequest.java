package com.egrocery_remasterd.egrocery_backend.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
