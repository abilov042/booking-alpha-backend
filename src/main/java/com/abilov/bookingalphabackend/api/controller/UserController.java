package com.abilov.bookingalphabackend.api.controller;

import com.abilov.bookingalphabackend.business.abstractes.UserService;
import com.abilov.bookingalphabackend.core.result.DataResult;
import com.abilov.bookingalphabackend.core.result.Result;
import com.abilov.bookingalphabackend.entity.concretes.User;
import com.abilov.bookingalphabackend.entity.dtos.SignupRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/findByEmail")
    public ResponseEntity<DataResult<User>> findByEmail(String email){

        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<Result> addUser(@RequestBody @Valid SignupRequest signupRequest){

        return ResponseEntity.ok(userService.addUser(signupRequest));
    }
}
