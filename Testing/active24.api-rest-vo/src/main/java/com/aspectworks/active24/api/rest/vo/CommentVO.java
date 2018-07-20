package com.aspectworks.active24.api.rest.vo;

import java.util.Date;
import javax.persistence.*;

@Entity
public class CommentVO {
    private String comment;
    private String user;
    private Date date;
    @Id
    private int commentID;

    @Override
    public String toString() {
        return
                "comment='" + comment + '\'' +
                ", date=" + date +
                ", commentid=" + commentID +
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

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }
}
