package com.Rootcore.bytehub_dashboard;

import java.sql.Time;

public class Gateway_event
{   private int id;
    private String bytehub_id;

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

    public Time getCreated_t() {
        return created_t;
    }

    public void setCreated_t(Time created_t) {
        this.created_t = created_t;
    }

    private String route_id;
    private String query;
    private String cid;
    private Time created_t;
}
