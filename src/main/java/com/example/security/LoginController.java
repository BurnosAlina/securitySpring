package com.example.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    String loginForm (){
        return "login-form";
    }

    @GetMapping("/register")
        String register(){
        return "register";
    }

    @PostMapping("/register")
    String registration(UserRegistrationDto dto){
        userService.register(dto);
        return "login-form";
    }
}
