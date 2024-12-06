package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    @GetMapping("/login-no-oauth")
    public String login() {
        return "login-no-oauth"; // This refers to the file "login-no-oauth.html" in the templates folder
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
