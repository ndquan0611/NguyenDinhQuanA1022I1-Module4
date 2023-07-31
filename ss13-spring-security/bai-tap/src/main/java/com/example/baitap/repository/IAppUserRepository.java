package com.example.baitap.repository;

import com.example.baitap.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
