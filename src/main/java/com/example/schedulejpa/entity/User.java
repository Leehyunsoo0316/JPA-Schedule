package com.example.schedulejpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void updateUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
