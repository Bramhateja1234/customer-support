package com.vcube.customer_support.service.impl;

import org.springframework.stereotype.Service;

import com.vcube.customer_support.dto.UserRequest;
import com.vcube.customer_support.dto.UserResponse;
import com.vcube.customer_support.entity.User;
import com.vcube.customer_support.repository.UserRepository;
import com.vcube.customer_support.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserResponse register(UserRequest request) {

        if (repo.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException(
                "Email already registered"
            );
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Replace this with BCrypt password hashing
        // before using authentication or deployment.
        user.setPassword(request.getPassword());

        user.setPhone(request.getPhone());
        user.setRole("CUSTOMER");

        User savedUser = repo.save(user);

        return new UserResponse(
            savedUser.getUserId(),
            savedUser.getName(),
            savedUser.getEmail(),
            savedUser.getRole()
        );
    }
}