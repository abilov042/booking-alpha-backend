package com.abilov.bookingalphabackend.business.abstractes;

import com.abilov.bookingalphabackend.core.result.DataResult;
import com.abilov.bookingalphabackend.core.result.Result;
import com.abilov.bookingalphabackend.entity.concretes.User;
import com.abilov.bookingalphabackend.entity.dtos.SignupRequest;

public interface UserService {
    Result addUser(SignupRequest signupRequest);
    DataResult<User> findByEmail(String email);
}
