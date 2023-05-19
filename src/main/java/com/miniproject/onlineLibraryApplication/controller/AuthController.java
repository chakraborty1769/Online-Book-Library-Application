package com.miniproject.onlineLibraryApplication.controller;

import com.miniproject.onlineLibraryApplication.model.AuthenticationRequest;
import com.miniproject.onlineLibraryApplication.model.AuthenticationResponse;
import com.miniproject.onlineLibraryApplication.service.implementation.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/login")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        return new ResponseEntity<>(authenticationService.login(authenticationRequest), HttpStatus.OK);
    }
}
