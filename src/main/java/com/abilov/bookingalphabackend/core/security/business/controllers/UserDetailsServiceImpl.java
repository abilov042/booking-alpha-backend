package com.abilov.bookingalphabackend.core.security.business.controllers;

import com.abilov.bookingalphabackend.core.security.business.abstaracts.UserDetailsService;
import com.abilov.bookingalphabackend.core.security.entities.UserDetailsImpl;
import com.abilov.bookingalphabackend.dataAccess.abstractes.UserDao;
import com.abilov.bookingalphabackend.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

        return UserDetailsImpl.build(user);
    }
}
