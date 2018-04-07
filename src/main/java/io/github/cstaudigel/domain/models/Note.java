package io.github.cstaudigel.domain.models;

import java.sql.Date;

public class Note {

    private String title;
    private String content;
    private Date creationDate;
    private int ID;

    public Note(String title, String content, Date creationDate, int ID) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
