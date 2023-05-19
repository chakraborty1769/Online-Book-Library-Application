package com.miniproject.onlineLibraryApplication.service;

import com.miniproject.onlineLibraryApplication.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register (UserRequestModel userRequestModel);
}
