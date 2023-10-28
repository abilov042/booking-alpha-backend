package com.abilov.bookingalphabackend.business.concretes;

import com.abilov.bookingalphabackend.business.abstractes.UserService;
import com.abilov.bookingalphabackend.core.excepstions.config.NotFountException;
import com.abilov.bookingalphabackend.dataAccess.abstractes.UserDao;
import com.abilov.bookingalphabackend.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;
    @Override
    public User findByEmail(String email) {

        User user = userDao.findByEmail(email).orElseThrow(() -> new NotFountException("User Not found"));

        return null;
    }
}
