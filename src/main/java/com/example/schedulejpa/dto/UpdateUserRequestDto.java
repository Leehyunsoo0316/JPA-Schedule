package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class UpdateUserRequestDto {
    private final String oldPassword;
    private final String name;
    private final String email;
    private final String newPassword;

    public UpdateUserRequestDto(String oldPassword, String name, String email, String newPassword) {
        this.oldPassword = oldPassword;
        this.name = name;
        this.email = email;
        this.newPassword = newPassword;
    }
}
