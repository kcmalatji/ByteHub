package com.Rootcore.bytehub_dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class TabbedController {
    ArrayList<Gateway_event> DATA=new ArrayList<>();
    ArrayList<Gateway_event_message> GatewayEventMessagesArray=new ArrayList<>();
    ArrayList<History_event> HistoryEventsArray=new ArrayList<>();
    ArrayList<History_event_messages> HistoryEventMessagesArray=new ArrayList<>();
    private Connection connect=null;
    private Statement statement = null;
    private Statement gatewayEventstatement = null;
    private Statement historyEventstatement = null;
    private Statement historyEvenMessageststatement = null;
    private PreparedStatement preparedStatement=null;
    private ResultSet resultSet=null;
    private ResultSet gateway_event_messages=null;
   private ResultSet history_event=null;
    private ResultSet history_event_messages=null;
    public void readDataBase() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytehub_dashboard?autoReconnect=true&useSSL=false&"+"user=root&password=root");
        statement= connect.createStatement();
        gatewayEventstatement=connect.createStatement();
        historyEventstatement=connect.createStatement();
        historyEvenMessageststatement=connect.createStatement();
        resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
        gateway_event_messages=gatewayEventstatement.executeQuery("select * from bytehub_dashboard.gateway_event_messages");
       history_event=historyEventstatement.executeQuery("select * from bytehub_dashboard.history_events");
       history_event_messages=historyEvenMessageststatement.executeQuery("select * from bytehub_dashboard.history_event_messages");
//        writeMetaData(resultSet);
        writeResultset(resultSet);
        writegateway_event_messages(gateway_event_messages);
        writeHistoryEvents(history_event);
        writeHistoryEventMmessages(history_event_messages);
    }
//
//    public void writeMetaData(ResultSet resultSet) throws SQLException{
//        System.out.println("the colums in the table are");
//        System.out.println("Table : "+ resultSet.getMetaData().getTableName(1) );
//        for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++)
//        {
//            System.out.println("column "+ i +" "+resultSet.getMetaData().getColumnName(i));
//        }
//    }
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
    public ArrayList writegateway_event_messages(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            Gateway_event_message gateway_event_message =new Gateway_event_message();
            String bytehub_id=resultSet.getString("bytehub_id");
            String digest=resultSet.getString("digest");
            String message=resultSet.getString("message");
            Timestamp created_t=resultSet.getTimestamp("created_t");
            gateway_event_message.setBytehub_id(bytehub_id);
            gateway_event_message.setCreated_t(created_t);
            gateway_event_message.setMessage(message);
            gateway_event_message.setDigest(digest);
            GatewayEventMessagesArray.add(gateway_event_message);
        }

        return GatewayEventMessagesArray;

    }
    public ArrayList writeHistoryEvents(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            History_event history_event =new History_event();
            String bytehub_id=resultSet.getString("bytehub_id");
            String package_id=resultSet.getString("package_id");
            String route_id=resultSet.getString("route_id");
            String query=resultSet.getString("query");
            String operation_id=resultSet.getString("operation_id");
            Timestamp created_t=resultSet.getTimestamp("created_t");
            history_event.setBytehub_id(bytehub_id);
            history_event.setCreated_t(created_t);
            history_event.setQuery(query);
            history_event.setOperation_id(operation_id);
            history_event.setPackage_id(package_id);
            history_event.setRoute_id(route_id);
            HistoryEventsArray.add(history_event);
        }

        return HistoryEventsArray;

    }
    public ArrayList writeHistoryEventMmessages(ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            History_event_messages history_event_messages =new History_event_messages();
            String bytehub_id=resultSet.getString("bytehub_id");
            String digest=resultSet.getString("digest");
            String message=resultSet.getString("message");
            Timestamp created_t=resultSet.getTimestamp("created_t");
            history_event_messages.setBytehub_id(bytehub_id);
            history_event_messages.setCreated_t(created_t);
            history_event_messages.setMessage(message);
            history_event_messages.setDigest(digest);
            HistoryEventMessagesArray.add(history_event_messages);
        }
        return GatewayEventMessagesArray;
    }

    @GetMapping("/tabbedview")
    String tabbed(Model model) throws Exception {

        readDataBase();
//        System.out.println( DATA.size());
        model.addAttribute("data",DATA);
        model.addAttribute("gateway_event_messages",GatewayEventMessagesArray);
        model.addAttribute("HistoryEventsArray",HistoryEventsArray);
        model.addAttribute("HistoryEventMessagesArray",HistoryEventMessagesArray);
        return "TabbedView";
    }
}
