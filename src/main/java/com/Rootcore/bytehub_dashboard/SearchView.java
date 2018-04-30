package com.Rootcore.bytehub_dashboard;

import java.sql.*;
import java.util.ArrayList;

public class SearchView {
    ArrayList<Gateway_event> DATA=new ArrayList<>();
    private Connection connect=null;
    private Statement statement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    private ResultSet gateway_event_messages=null;
    private ResultSet history_event=null;
    private ResultSet history_event_messages=null;
    public void readDataBase() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytehub_dashboard?autoReconnect=true&useSSL=false&"+"user=root&password=root");
        statement= connect.createStatement();
        resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
        gateway_event_messages=statement.executeQuery("select * from bytehub_dashboard.gateway_event_messages");

        //       Timestamp timestamp=new Timestamp(System.currentTimeMillis());
//        preparedStatement=connect.prepareStatement("insert into  bytehub_dashboard.gateway_events values (default ,?,?,?,?,?,?)");
//    preparedStatement.setString(1,"test1");
//    preparedStatement.setString(2,"test1");
//    preparedStatement.setString(3,"test1");
//    preparedStatement.setString(4,"test1");
//    preparedStatement.setString(5,"test1");
//    preparedStatement.setTimestamp(6,new java.sql.Timestamp(timestamp.getTime()));
//    preparedStatement.executeUpdate();
//    resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
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
    public ArrayList writeResultset(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            Gateway_event gateway =new Gateway_event();
            String bytehub_id=resultSet.getString("bytehub_id");
            String package_id=resultSet.getString("package_id");
            String route_id=resultSet.getString("route_id");
            String query=resultSet.getString("query");
            String cid=resultSet.getString("cid");
            Timestamp created_t=resultSet.getTimestamp("created_t");
            gateway.setBytehub_id(bytehub_id);
            gateway.setCreated_t(created_t);
            gateway.setQuery(query);
            gateway.setCid(cid);
            gateway.setPackage_id(package_id);
            gateway.setRoute_id(route_id);
            DATA.add(gateway);
        }

        return DATA;

    }



}
