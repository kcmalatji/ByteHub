package com.Rootcore.bytehub_dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    String login(){

        return "login";
    }
    @PostMapping("/")
    String loginsubmit(){

        return "Dashboard";
    }
}
