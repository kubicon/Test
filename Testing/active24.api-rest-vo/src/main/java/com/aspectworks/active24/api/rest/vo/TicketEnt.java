package com.aspectworks.active24.api.rest.vo;


import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TicketEnt {
    private String theme;
    private Date date;
    private int ticketID;
    ArrayList<CommentVO> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "TicketVO{" +
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

    public ArrayList<CommentVO> getComments() {
        return comments;
    }
    public void addComment(CommentVO comment){
        comments.add(comment);
    }
}