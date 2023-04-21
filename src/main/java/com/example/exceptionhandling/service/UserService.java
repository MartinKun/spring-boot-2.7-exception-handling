package com.example.exceptionhandling.service;

import com.example.exceptionhandling.controller.request.UserRequest;
import com.example.exceptionhandling.entity.User;
import com.example.exceptionhandling.exception.ResourceNotFoundException;

public interface UserService {
    User saveUser(UserRequest request);

    User getUserById(Long id) throws ResourceNotFoundException;
}
