package com.example.exceptionhandling.service.implementation;

import com.example.exceptionhandling.controller.request.UserRequest;
import com.example.exceptionhandling.entity.User;
import com.example.exceptionhandling.exception.ResourceNotFoundException;
import com.example.exceptionhandling.repository.UserRepository;
import com.example.exceptionhandling.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public User saveUser(UserRequest request) {
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .build();
        return userRepo.save(user);
    }

    public User getUserById(Long id) throws ResourceNotFoundException {
        return userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with specified ID does not exist.")
        );
    }

}
