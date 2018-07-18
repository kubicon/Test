package com.aspectworks.active24.api.rest.vo;

import java.util.Date;

public class CommentVO {
    private String comment;
    private String user;
    private Date date;

    @Override
    public String toString() {
        return "CommentVO{" +
                "comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
