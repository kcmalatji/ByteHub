package com.Rootcore.bytehub_dashboard;

import java.sql.*;

public class SearchView {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBytehub_id() {
        return bytehub_id;
    }

    public void setBytehub_id(String bytehub_id) {
        this.bytehub_id = bytehub_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public Timestamp getCreated_t() {
        return created_t;
    }

    public void setCreated_t(Timestamp created_t) {
        this.created_t = created_t;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(String operation_id) {
        this.operation_id = operation_id;
    }

    private int id;
    private String bytehub_id;
    private String route_id;
    private String query;
    private String cid;
    private String package_id;
    private Timestamp created_t;
    private String digest;
    private String message;
    private String operation_id;







































//    ArrayList<Gateway_event> DATA=new ArrayList<>();
//    private Connection connect=null;
//    private Statement statement = null;
//    private PreparedStatement preparedStatement=null;
//    private ResultSet resultSet=null;
//    private ResultSet gateway_event_messages=null;
//    private ResultSet history_event=null;
//    private ResultSet history_event_messages=null;
//    public void readDataBase() throws Exception{
//        Class.forName("com.mysql.jdbc.Driver");
//        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bytehub_dashboard?autoReconnect=true&useSSL=false&"+"user=root&password=root");
//        statement= connect.createStatement();
//        resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
//        gateway_event_messages=statement.executeQuery("select * from bytehub_dashboard.gateway_event_messages");
//
//        //       Timestamp timestamp=new Timestamp(System.currentTimeMillis());
////        preparedStatement=connect.prepareStatement("insert into  bytehub_dashboard.gateway_events values (default ,?,?,?,?,?,?)");
////    preparedStatement.setString(1,"test1");
////    preparedStatement.setString(2,"test1");
////    preparedStatement.setString(3,"test1");
////    preparedStatement.setString(4,"test1");
////    preparedStatement.setString(5,"test1");
////    preparedStatement.setTimestamp(6,new java.sql.Timestamp(timestamp.getTime()));
////    preparedStatement.executeUpdate();
////    resultSet=statement.executeQuery("select * from bytehub_dashboard.gateway_events");
//        writeMetaData(resultSet);
//
//        writeResultset(resultSet);
//    }
//    public void writeMetaData(ResultSet resultSet) throws SQLException{
//        System.out.println("the colums in the table are");
//        System.out.println("Table : "+ resultSet.getMetaData().getTableName(1) );
//        for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++)
//        {
//            System.out.println("column "+ i +" "+resultSet.getMetaData().getColumnName(i));
//        }
//    }
//    public ArrayList writeResultset(ResultSet resultSet)throws SQLException{
//        while(resultSet.next()){
//            Gateway_event gateway =new Gateway_event();
//            String bytehub_id=resultSet.getString("bytehub_id");
//            String package_id=resultSet.getString("package_id");
//            String route_id=resultSet.getString("route_id");
//            String query=resultSet.getString("query");
//            String cid=resultSet.getString("cid");
//            Timestamp created_t=resultSet.getTimestamp("created_t");
//            gateway.setBytehub_id(bytehub_id);
//            gateway.setCreated_t(created_t);
//            gateway.setQuery(query);
//            gateway.setCid(cid);
//            gateway.setPackage_id(package_id);
//            gateway.setRoute_id(route_id);
//            DATA.add(gateway);
//        }
//
//        return DATA;
//
//    }



}
