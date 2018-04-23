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
       Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        preparedStatement=connect.prepareStatement("insert into  bytehub_dashboard.gateway_events values (default ,?,?,?,?,?,?)");
    preparedStatement.setString(1,"test1");
    preparedStatement.setString(2,"test1");
    preparedStatement.setString(3,"test1");
    preparedStatement.setString(4,"test1");
    preparedStatement.setString(5,"test1");

    preparedStatement.setTimestamp(6,new java.sql.Timestamp(timestamp.getTime()));
    preparedStatement.executeUpdate();



    resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
    writeMetaData(resultSet);
        writeResultset(resultSet);



    }
    public void writeMetaData(ResultSet resultSet) throws SQLException{
        System.out.println("the colums in the table are");
        System.out.println("Table : "+ resultSet.getMetaData().getTableName(1) );
        for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++)
        {
            System.out.println("column "+ i +" "+resultSet.getMetaData().getColumnName(i));
        }
    }
    public void writeResultset(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
             String bytehub_id=resultSet.getString("bytehub_id");
             String package_id=resultSet.getString("package_id");
             String route_id=resultSet.getString("route_id");
             String query=resultSet.getString("query");
             String cid=resultSet.getString("cid");
             Timestamp created_t=resultSet.getTimestamp("created_t");
            System.out.println("bytehub_id :"+ bytehub_id);
            System.out.println("package_id :"+package_id);
            System.out.println("route_id :"+route_id);
            System.out.println("query :"+ query);
            System.out.println("cid :"+ cid);
            System.out.println("created_t :"+ created_t);
        }
    }

    @GetMapping("/tabbedview")
    String tabbed() throws Exception {

        readDataBase();
        return "TabbedView";
    }
}
