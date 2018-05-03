package com.Rootcore.bytehub_dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class SearchViewController {
    ArrayList<SearchView> SEARCHVIEW=new ArrayList<>();

    private Connection connect=null;
    private Statement statement = null;
    private ResultSet resultSet=null;

    public void readDataBase() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytehub_dashboard?autoReconnect=true&useSSL=false&"+"user=root&password=root");
        statement= connect.createStatement();
        resultSet=statement.executeQuery("SELECT a.bytehub_id, a.package_id, a.cid, a.route_id, b.digest, b.message, c.operation_id, c.query, c.route_id, d.digest, d.message, d.created_t \n" +
                "from bytehub_dashboard.gateway_events a, bytehub_dashboard.gateway_event_messages b, bytehub_dashboard.history_events c, bytehub_dashboard.history_event_messages d \n" +
                "where a.id=b.id=c.id=d.id ");

       writeResultset(resultSet);

    }
    public ArrayList writeResultset(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){

            SearchView search=new SearchView();
            String bytehub_id=resultSet.getString("bytehub_id");
            String package_id=resultSet.getString("package_id");
            String route_id=resultSet.getString("route_id");
            String query=resultSet.getString("query");
            String digest=resultSet.getString("digest");
            Timestamp created_t=resultSet.getTimestamp("created_t");
            search.setBytehub_id(bytehub_id);
            search.setCreated_t(created_t);
            search.setQuery(query);
            search.setCid(digest);
            search.setPackage_id(package_id);
            search.setRoute_id(route_id);
            SEARCHVIEW.add(search);
        }

        return SEARCHVIEW;

    }



    @GetMapping("/searchview")
    String searchview(Model model) throws Exception {
        readDataBase();
        System.out.println( SEARCHVIEW.size());
        model.addAttribute("SEARCHVIEW", SEARCHVIEW);
        return "SearchView";
    }
}
