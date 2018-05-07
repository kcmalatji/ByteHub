package com.Rootcore.bytehub_dashboard;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.*;
import java.util.ArrayList;


@Controller
public class LoginController {

    private Connection connect=null;
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;

    public void readDataBase(String name,String surname,String email, String password) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytehub_dashboard?autoReconnect=true&useSSL=false&"+"user=root&password=root");
        statement= connect.createStatement();


        //resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
//        String sql ="INSERT INTO `users`('id' , `name`, `lastname`, `email`, `password`) VALUES (default,?,?,?,?)";
        String sql="insert into  bytehub_dashboard.users values (default ,?,?,?,?)";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, password);
        preparedStatement.executeUpdate();

    }



    @GetMapping("/")
    String login(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/")
    String loginsubmit(@ModelAttribute User user){
        System.out.println(user.name);

        return "Dashboard";
    }







    @GetMapping("/register")
    String register(Model model)  {
        model.addAttribute("register",new User());


        return "register";
    }
    @PostMapping("/register")
    String registersubmit(@ModelAttribute User register) throws Exception {
        readDataBase(register.getName(),register.getSurname(),register.getEmail(),register.getPassword());
        System.out.println(register.getId());
        System.out.println(register.getName());
        System.out.println(register.getSurname());
        System.out.println(register.getEmail());
        System.out.println(register.getPassword());
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
