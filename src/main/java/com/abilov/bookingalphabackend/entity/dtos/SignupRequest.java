package com.abilov.bookingalphabackend.entity.dtos;

import com.abilov.bookingalphabackend.entity.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String email;
    private String fullName;
    private String password;
    private Set<String> role;
}
