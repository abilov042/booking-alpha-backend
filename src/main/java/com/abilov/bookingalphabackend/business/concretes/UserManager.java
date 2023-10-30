package com.abilov.bookingalphabackend.business.concretes;

import com.abilov.bookingalphabackend.business.abstractes.UserService;
import com.abilov.bookingalphabackend.core.excepstions.config.ConfirmPasswordException;
import com.abilov.bookingalphabackend.core.excepstions.config.ExistsEmailException;
import com.abilov.bookingalphabackend.core.excepstions.config.NotFountException;
import com.abilov.bookingalphabackend.core.result.*;
import com.abilov.bookingalphabackend.dataAccess.abstractes.RoleDao;
import com.abilov.bookingalphabackend.dataAccess.abstractes.UserDao;
import com.abilov.bookingalphabackend.entity.concretes.ERole;
import com.abilov.bookingalphabackend.entity.concretes.Role;
import com.abilov.bookingalphabackend.entity.concretes.User;
import com.abilov.bookingalphabackend.entity.dtos.requests.LoginRequest;
import com.abilov.bookingalphabackend.entity.dtos.requests.SignupRequest;
import com.abilov.bookingalphabackend.entity.dtos.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    @Override
    public Result register(SignupRequest signupRequest){
        User user = new User();
        if(!signupRequest.getPassword().equals(signupRequest.getCPassword())){
            throw new ConfirmPasswordException("Password not same");
        }
        else if(userDao.existsByEmail(signupRequest.getEmail())){
            throw new ExistsEmailException("email already exists");
        }else {
            user.setFullName(signupRequest.getFullName());
            user.setEmail(signupRequest.getEmail());
            String passwordE = Base64.getEncoder().encodeToString(signupRequest.getPassword().getBytes());
            user.setPassword(passwordE);
            Set<Role> roles = new HashSet<>();
            Role role = roleDao.findByName(ERole.ROLE_USER).orElseThrow(()-> new NotFountException("Role not found"));
            roles.add(role);
            user.setRoles(roles);
            userDao.save(user);
            return new SuccessResult("user successfully added");
        }
    }

    @Override
    public DataResult<User> findByEmail(String email) {

        User user = userDao.findByEmail(email).orElseThrow(() -> new NotFountException("User Not found"));

        return new SuccessDataResult<>(user,"user is found");
    }

    @Override
    public DataResult<UserResponse> login(LoginRequest loginRequest) {
        User user = userDao.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new NotFountException("user not found"));
        String passwordE = Base64.getEncoder().encodeToString(loginRequest.getPassword().getBytes());
        if(!passwordE.equals(user.getPassword())){
            throw new NotFountException("Password doesn't correct");
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFullName(user.getFullName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRoles());
        return new SuccessDataResult<>(userResponse, "user successfully found");
    }
}
