package io.github.cstaudigel.domain.models;

import java.sql.Date;

public class InvolvementRequest {

    private String name;
    private String email;
    private String phone;
    private String message;
    private Date timestamp;
    private int ID;

    public InvolvementRequest(String name, String email, String phone, String message, Date timestamp, int ID) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.timestamp = timestamp;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
