package com.example.exceptionhandling.repository;

import com.example.exceptionhandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
