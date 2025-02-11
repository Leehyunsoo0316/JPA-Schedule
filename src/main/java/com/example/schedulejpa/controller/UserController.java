package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.UserRequestDto;
import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto dto) {
        UserResponseDto userResponseDto = userService.save(dto.getName(), dto.getEmail(), dto.getPassword());
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
