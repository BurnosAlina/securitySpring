package com.example.security;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    UserDetailsRepository userDetailsRepository;

    UserRoleRepository userRoleRepository;
    UserDtoMapper mapper = new UserDtoMapper();

    PasswordEncoder passwordEncoder;

    public UserService(UserDetailsRepository userDetailsRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register (UserRegistrationDto dto){
        UserDetails user = new UserDetails();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        user.setPassword(passwordHash);

        Optional<UserRole> role = userRoleRepository.findByName("User");
        if (role.isPresent()) {
            user.setRoles(new HashSet<>(Collections.singletonList(role.get())));
        } else {
            throw new NoSuchElementException("Nie ma takiej roli");
        }

        userDetailsRepository.save(user);
    }

    public UserDetailsDto findUser (String email) {
        Optional<UserDetails> byEmail = userDetailsRepository.findByEmail(email);
        if (byEmail.isPresent()){
            return mapper.convertToDto(byEmail.get());
        } else {
            throw new NoSuchElementException("Nie ma takiego");
        }
    }

}
