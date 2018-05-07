package com.Rootcore.bytehub_dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.*;

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
    @GetMapping("/register")
    String register(){

        return "register";
    }
    @PostMapping("/register")
    String registersubmit(){

        return "login";
    }
    @GetMapping("/forgot")
    String forgot(){

        return "forgot_password";
    }
    @PostMapping("/forgot")
    String forgotsubmit(){

        return "login";
    }
}
