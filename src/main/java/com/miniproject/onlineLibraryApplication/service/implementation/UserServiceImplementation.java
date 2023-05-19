package com.miniproject.onlineLibraryApplication.service.implementation;

import com.miniproject.onlineLibraryApplication.entity.Role;
import com.miniproject.onlineLibraryApplication.entity.UserEntity;
import com.miniproject.onlineLibraryApplication.model.AuthenticationResponse;
import com.miniproject.onlineLibraryApplication.model.UserRequestModel;
import com.miniproject.onlineLibraryApplication.model.UserResponseModel;
import com.miniproject.onlineLibraryApplication.repository.UserRepository;
import com.miniproject.onlineLibraryApplication.service.UserService;
import com.miniproject.onlineLibraryApplication.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public ResponseEntity<Object> register(UserRequestModel userRequestModel) {
            UserEntity userEntity = UserEntity.builder()
                    .email(userRequestModel.getEmail())
                    .address(userRequestModel.getAddress())
                    .firstName(userRequestModel.getFirstName())
                    .lastName(userRequestModel.getLastName())
                    .password(passwordEncoder.encode(userRequestModel.getPassword()))
                    .role(userRequestModel.getRole())
                    .build();
            userRepository.save(userEntity);
            AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwtService.generateToken(userEntity))
                .build();
            return new ResponseEntity<>(authenticationResponse, HttpStatus.CREATED);
    }

}
