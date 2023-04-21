package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.controller.response.MessageResponse;
import com.example.exceptionhandling.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> throwGeneralException(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());
        return ResponseEntity.internalServerError()
                .body(new MessageResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        errorMap)
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse> handleInvalidArgument(
            MethodArgumentNotValidException ex
    ) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error -> {
                            errorMap.put(
                                    error.getField(),
                                    error.getDefaultMessage()
                            );
                        }
                );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        errorMap));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageResponse> handleResourceNorFound(
            ResourceNotFoundException ex
    ) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageResponse(HttpStatus.NOT_FOUND.value(), errorMap));
    }
}
