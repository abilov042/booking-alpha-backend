package com.abilov.bookingalphabackend.dataAccess.abstractes;

import com.abilov.bookingalphabackend.entity.concretes.ERole;
import com.abilov.bookingalphabackend.entity.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole roleName);
}
