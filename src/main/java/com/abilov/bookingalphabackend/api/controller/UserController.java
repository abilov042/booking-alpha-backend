package com.abilov.bookingalphabackend.api.controller;

import com.abilov.bookingalphabackend.business.abstractes.UserService;
import com.abilov.bookingalphabackend.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/findByEmail")
    public ResponseEntity<User> findByEmail(String email){

        return ResponseEntity.ok(userService.findByEmail(email));
    }
}
