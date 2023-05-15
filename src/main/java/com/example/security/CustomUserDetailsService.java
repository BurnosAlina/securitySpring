package com.example.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsDto user = userService.findUser(username);
        return createUserDetails(user);
    }

    private UserDetails createUserDetails (UserDetailsDto credentials){
        List<SimpleGrantedAuthority> authorities = credentials.getRoles()
                .stream()
                .map((UserRole role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .authorities(authorities)
                .build();
    }
}
