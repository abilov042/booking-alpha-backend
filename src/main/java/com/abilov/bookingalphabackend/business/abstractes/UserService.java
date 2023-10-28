package com.abilov.bookingalphabackend.business.abstractes;

import com.abilov.bookingalphabackend.entity.concretes.User;

public interface UserService {
    User findByEmail(String email);
}
