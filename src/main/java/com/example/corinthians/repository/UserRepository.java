package com.example.corinthians.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.corinthians.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
