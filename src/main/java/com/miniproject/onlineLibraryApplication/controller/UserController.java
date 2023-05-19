package com.miniproject.onlineLibraryApplication.controller;

import com.miniproject.onlineLibraryApplication.model.UserRequestModel;
import com.miniproject.onlineLibraryApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> register (@RequestBody UserRequestModel userRequestModel){
        return userService.register(userRequestModel);
    }
}
