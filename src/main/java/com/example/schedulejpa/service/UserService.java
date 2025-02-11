package com.example.schedulejpa.service;

import com.example.schedulejpa.dto.UserResponseDto;
import com.example.schedulejpa.entity.User;
import com.example.schedulejpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        return new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail(), findUser.getCreatedAt(), findUser.getUpdatedAt());
    }

    @Transactional
    public void updateUser(Long id, String oldPassword, String name, String email, String newPassword) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        findUser.updateUser(name, email, newPassword);
    }

    public void deleteUser(Long id, String password) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        if (!findUser.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        userRepository.delete(findUser);
    }
}
