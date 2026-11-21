package com.vcube.customer_support.controller;

import org.springframework.web.bind.annotation.*;

import com.vcube.customer_support.dto.UserRequest;
import com.vcube.customer_support.dto.UserResponse;
import com.vcube.customer_support.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserResponse register(
            @RequestBody UserRequest request) {

        return service.register(request);
    }
}

// POST   http://localhost:8080/api/users/register