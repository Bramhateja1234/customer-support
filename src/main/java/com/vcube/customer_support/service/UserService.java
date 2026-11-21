package com.vcube.customer_support.service;

import com.vcube.customer_support.dto.UserRequest;
import com.vcube.customer_support.dto.UserResponse;

public interface UserService {

    UserResponse register(UserRequest request);

}