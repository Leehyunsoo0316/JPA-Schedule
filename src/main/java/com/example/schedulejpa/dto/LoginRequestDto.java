package com.example.schedulejpa.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    @Email
    @Column(nullable = false)
    private final String email;
    @Column(nullable = false)
    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
