package com.Rootcore.bytehub_dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;

@Controller
public class TabbedController {
    private Connection connect=null;
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    public void readDataBase() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytehub_dashboard?autoReconnect=true&useSSL=false&"+"user=root&password=root");
        statement= connect.createStatement();
        resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
//        writeResultSet(resultSet);
       Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        preparedStatement=connect.prepareStatement("insert into  bytehub_dashboard.gateway_events values (default ,?,?,?,?,?,?)");
    preparedStatement.setString(1,"test1");
    preparedStatement.setString(2,"test1");
    preparedStatement.setString(3,"test1");
    preparedStatement.setString(4,"test1");
    preparedStatement.setString(5,"test1");
//    preparedStatement.setTimestamp(6,new java.sql.Timestamp(1400,04,12,9,12,56,0));
    preparedStatement.setTimestamp(6,new java.sql.Timestamp(timestamp.getTime()));
    preparedStatement.executeUpdate();
        System.out.println("information added");
    }

    @GetMapping("/tabbedview")
    String tabbed() throws Exception {

        readDataBase();
        return "TabbedView";
    }
}
