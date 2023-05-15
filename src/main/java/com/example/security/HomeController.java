package com.example.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    UserDetailsRepository userDetailsRepository;

    public HomeController(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/secure")
    String secure() {
        return "secure";
    }

    @GetMapping("/admin")
    String admin(Model model) {
        Iterable<UserDetails> all = userDetailsRepository.findAll();
        model.addAttribute("users", all);
        return "admin";
    }
}


