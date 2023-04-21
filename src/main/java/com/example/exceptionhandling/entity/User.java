package com.example.exceptionhandling.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
}
