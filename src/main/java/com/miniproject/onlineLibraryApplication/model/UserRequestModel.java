package com.miniproject.onlineLibraryApplication.model;

import com.miniproject.onlineLibraryApplication.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private Role role;
}
