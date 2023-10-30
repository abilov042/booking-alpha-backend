package com.abilov.bookingalphabackend.business.abstractes;

import com.abilov.bookingalphabackend.core.result.DataResult;
import com.abilov.bookingalphabackend.core.result.Result;
import com.abilov.bookingalphabackend.entity.concretes.User;
import com.abilov.bookingalphabackend.entity.dtos.requests.LoginRequest;
import com.abilov.bookingalphabackend.entity.dtos.requests.SignupRequest;
import com.abilov.bookingalphabackend.entity.dtos.response.UserResponse;

public interface UserService {
    Result register(SignupRequest signupRequest);
    DataResult<UserResponse> login(LoginRequest loginRequest);
    DataResult<User> findByEmail(String email);

}
