package com.example.schedulejpa.dto;

import lombok.Getter;

@Getter
public class DeleteUserRequestDto {
    private final String password;

    public DeleteUserRequestDto(String password) {
        this.password = password;
    }
}
