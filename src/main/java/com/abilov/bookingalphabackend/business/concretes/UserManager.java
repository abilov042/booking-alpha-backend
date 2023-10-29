package com.abilov.bookingalphabackend.business.concretes;

import com.abilov.bookingalphabackend.business.abstractes.UserService;
import com.abilov.bookingalphabackend.core.excepstions.config.ConfirmPasswordException;
import com.abilov.bookingalphabackend.core.excepstions.config.ExistsEmailException;
import com.abilov.bookingalphabackend.core.excepstions.config.NotFountException;
import com.abilov.bookingalphabackend.core.result.*;
import com.abilov.bookingalphabackend.dataAccess.abstractes.UserDao;
import com.abilov.bookingalphabackend.entity.concretes.User;
import com.abilov.bookingalphabackend.entity.dtos.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;

    @Override
    public Result addUser(SignupRequest signupRequest){
        User user = new User();
        if(!signupRequest.getPassword().equals(signupRequest.getCPassword())){
            throw new ConfirmPasswordException("Password not same");
        }
        else if(userDao.existsByEmail(signupRequest.getEmail())){
            throw new ExistsEmailException("email already exists");
        }else {
            user.setFullName(signupRequest.getFullName());
            user.setEmail(signupRequest.getEmail());
            user.setPassword(signupRequest.getPassword());
            userDao.save(user);
            return new SuccessResult("user successfully added");
        }
    }

    @Override
    public DataResult<User> findByEmail(String email) {

        User user = userDao.findByEmail(email).orElseThrow(() -> new NotFountException("User Not found"));

        return new SuccessDataResult<User>(user,"user is found");
    }
}
