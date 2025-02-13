package com.example.schedulejpa.controller;

import com.example.schedulejpa.dto.*;
import com.example.schedulejpa.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto dto) {
        UserResponseDto userResponseDto = userService.save(dto.getName(), dto.getEmail(), dto.getPassword());
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequestDto dto) {
        userService.updateUser(id, dto.getOldPassword(), dto.getName(), dto.getEmail(), dto.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @RequestBody DeleteUserRequestDto dto) {
        userService.deleteUser(id, dto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
