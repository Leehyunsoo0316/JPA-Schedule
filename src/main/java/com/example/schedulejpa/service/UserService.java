package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.entity.User;
import com.example.schedulejpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(String name, String email, String password) {
        User user = new User(name, email, password);
        userRepository.save(user);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
