package com.stan.appsecurity.repository;

import com.stan.appsecurity.entity.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUsers,Long> {
    Optional<AppUsers> findByEmail(String email);
}
