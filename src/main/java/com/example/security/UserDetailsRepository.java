package com.example.security;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

    Optional<UserDetails> findByEmail(String email);
    List<UserDetails> findAllByRoles_Name(String role);
}
