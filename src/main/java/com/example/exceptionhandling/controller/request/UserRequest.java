package com.example.exceptionhandling.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotNull(message = "Firstname shouldn't be null.")
    @NotEmpty(message = "Firstname should't be empty.")
    private String firstname;
    @NotNull(message = "Lastname shouldn't be null.")
    @NotEmpty(message = "Lastname should't be empty.")
    private String lastname;
    @Email(message = "Invalid email address.")
    private String email;
}
