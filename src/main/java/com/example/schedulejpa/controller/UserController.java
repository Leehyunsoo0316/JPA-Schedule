package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.UserRequestDto;
import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto dto) {
        UserResponseDto userResponseDto = userService.save(dto.getName(), dto.getEmail(), dto.getPassword());
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserResponseDto> userResponseDtoList = userService.findAll();
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }
}
