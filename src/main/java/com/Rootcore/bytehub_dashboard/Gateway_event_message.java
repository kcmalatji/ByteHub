package com.Rootcore.bytehub_dashboard;

import java.sql.Time;

public class Gateway_event_message {
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

    public Time getCreated_t() {
        return created_t;
    }

    public void setCreated_t(Time created_t) {
        this.created_t = created_t;
    }

    private int id;
    private String bytehub_id;
    private String digest;
    private String message;
    private Time created_t;
}
