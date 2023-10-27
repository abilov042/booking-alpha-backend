package com.abilov.bookingalphabackend.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JwtResponse {
    private String jwt;
    private Long id;
    private String email;
    private String fullName;
    private List<String> roles;


}
