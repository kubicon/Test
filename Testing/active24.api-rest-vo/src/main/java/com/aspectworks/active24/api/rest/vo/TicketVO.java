package com.aspectworks.active24.api.rest.vo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TicketVO {
    private String theme;
    private Date date;
    private int ticketID;

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
    /*public int compareTo(TicketVO ticket2, int order, int value){
        int retval = 0;
        if (value == 0) {
            if (this.getDate().compareTo(ticket2.getDate()) > 0) {
                retval = 1;
            } else {
                retval = -1;
            }
        }
        else {
            if (this.getTheme().compareTo(ticket2.getTheme()) > 0){
                retval = 1;
            }
            else{
                retval = -1;
            }
        }
        if(order == 0){
            return retval;
        }
        else{
            return (retval == 1)? -1 : 1;
        }
    }*/
}
