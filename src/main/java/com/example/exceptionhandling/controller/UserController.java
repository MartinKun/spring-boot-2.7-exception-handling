package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.controller.request.UserRequest;
import com.example.exceptionhandling.entity.User;
import com.example.exceptionhandling.exception.ResourceNotFoundException;
import com.example.exceptionhandling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity saveUser(@Valid @RequestBody UserRequest request) {
        return new ResponseEntity<>(service.saveUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.CREATED);
    }

}
