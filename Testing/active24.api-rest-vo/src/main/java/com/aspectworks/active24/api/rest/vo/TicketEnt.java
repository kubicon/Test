package com.aspectworks.active24.api.rest.vo;

import javax.persistence.*;
import com.sun.javafx.beans.IDProperty;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class TicketEnt {
    private String theme;
    private Date date;
    @Id
    private int ticketID;

    @OneToMany(cascade=CascadeType.ALL)
    List<CommentVO> comments = new ArrayList<>();


    @Override
    public String toString() {
        return "TicketEnt{" +
                "theme='" + theme + '\'' +
                ", date=" + date +
                ", ticketID=" + ticketID +
                '}';
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public List<CommentVO> getComments() {
        return this.comments;
    }
    public void addComment(CommentVO comment){
        comments.add(comment);
    }
}