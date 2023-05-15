package com.example.security;

public class UserDtoMapper {

    public UserDetailsDto convertToDto (UserDetails userDetails){
        return new UserDetailsDto(userDetails.getFirstName(), userDetails.getLastName(),
                userDetails.getEmail(), userDetails.getPassword(), userDetails.getRoles());
    }
}
