package com.example.app;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(@AuthenticationPrincipal OidcUser oidcUser){
        if(oidcUser != null){
            String email = oidcUser.getEmail();
            userRepository.findByEmail(email).orElseGet(() -> {
                User newUser = new User();
                newUser.setEmail(email);
                newUser.setName(oidcUser.getFullName());
                return userRepository.save(newUser);
            });
        }
        return "home";
    }
}
