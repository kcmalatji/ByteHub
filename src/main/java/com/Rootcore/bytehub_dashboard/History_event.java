package com.Rootcore.bytehub_dashboard;


import java.sql.Timestamp;

public class History_event {
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

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public String getRoute_id() {
        return route_id;
    }

    public void setRoute_id(String route_id) {
        this.route_id = route_id;
    }

    public String getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(String operation_id) {
        this.operation_id = operation_id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }



    private int id;
    private String bytehub_id;
    private String package_id;
    private String route_id;
    private String operation_id;
    private String query;

    public Timestamp getCreated_t() {
        return created_t;
    }

    public void setCreated_t(Timestamp created_t) {
        this.created_t = created_t;
    }

    private Timestamp created_t;
}
