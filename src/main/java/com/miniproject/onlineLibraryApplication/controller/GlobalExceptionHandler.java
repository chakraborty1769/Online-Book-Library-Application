package com.miniproject.onlineLibraryApplication.controller;

import com.miniproject.onlineLibraryApplication.exception.PermissionDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({PermissionDeniedException.class, AuthenticationCredentialsNotFoundException.class})
    public ResponseEntity<Object> returnNotFoundException (Exception exception){
        if (exception instanceof PermissionDeniedException){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        else if (exception instanceof AuthenticationCredentialsNotFoundException){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
