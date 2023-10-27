package com.abilov.bookingalphabackend.dataAccess.abstractes;

import com.abilov.bookingalphabackend.entity.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
