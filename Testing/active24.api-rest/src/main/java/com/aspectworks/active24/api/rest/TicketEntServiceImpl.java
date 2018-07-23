package com.aspectworks.active24.api.rest;

;
import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TicketEnt;
import com.aspectworks.active24.api.rest.vo.TicketVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@Service
public class TicketEntServiceImpl {
    Logger logger = LoggerFactory.getLogger(TicketEntServiceImpl.class);
    static List<TicketEnt> tickets = new ArrayList<>();
    @Autowired
    private TicketRepository tr;

    public void createTicket(TicketVO ticket){
        TicketEnt ticketEnt = new TicketEnt();
        ticketEnt.setDate(new Date());
        ticketEnt.setTheme(ticket.getTheme());
        ticketEnt.setTicketID(ticket.getTicketID());
        /* //Without database
        tickets.add(ticketEnt);
        */
        tr.save(ticketEnt);
        logger.debug("Create ticket");
        System.out.println("Creating ticket with ID: "  + ticket.getTicketID());

    }

    public void deleteTicket(long ticketID){
        List<TicketEnt> foundTickets = tr.findAll();
        for (TicketEnt ticket: foundTickets){
            if (ticket.getTicketID() == ticketID){
                logger.debug("Delete ticket");
                tr.delete(ticket);
                System.out.println("Deleting ticket with ID: " + ticketID);
            }
        }
        //System.out.println("Deleting ticket with ID: " + ticketID);
        //tr.deleteByTicketID(ticketID);
        /* //Without database
        for (TicketEnt ticket: tickets){
            if (ticket.getTicketID() == ticketID){
                tr.remove(ticket);
            }
        }*/
    }
    public void createComment(CommentVO comment, long ticketid){

        /* //Without database
        for (TicketEnt ticket : tickets){
            if (ticket.getTicketID() == ticketid){
                comment.setDate(java.util.Calendar.getInstance().getTime());
                ticket.addComment(comment);
                System.out.println("New comment created: " + comment + "in ticket with id" + ticketid);
            }
        }
        */
        List<TicketEnt> foundTickets = tr.findAll();
        for (TicketEnt ticket : foundTickets){
            if (ticket.getTicketID() == ticketid){
                comment.setDate(new Date());
                for (CommentVO allComments : ticket.getComments()){
                    if (comment.getCommentID() == allComments.getCommentID()){
                        System.out.println("Error: trying to add comment with same ID: " + comment.getCommentID());
                        return;
                    }
                }
                ticket.addComment(comment);
                logger.debug("Create comment");
                tr.save(ticket);
                System.out.println("Creating new comment: " + comment + "in ticket with id " + ticketid);
            }
        }
    }/*
    public void deleteComment(int ticketid, int commentid){
        for (TicketEnt ticket : tickets){
            if (ticket.getTicketID() == ticketid){
                for (CommentVO  comment : ticket.getComments()){
                    if (comment.getCommentID() == commentid){
                        ticket.
                    }
                }
            }
        }
    }*/
    public List<CommentVO> getComments(long ticketid){
        /* //Without database
        for (TicketEnt ticket : tickets){
            if (ticket.getTicketID() == ticketid){
                return ticket.getComments();
            }
        }

        */
        List<TicketEnt> foundTickets = tr.findAll();
        logger.debug("Getting comments");
        System.out.println("Printing all Comments from ticket with ID: " + ticketid);
        for (TicketEnt ticket : foundTickets) {
            if (ticket.getTicketID() == ticketid) {
                return ticket.getComments();
            }
        }

        return null;
    }
    public List<TicketEnt> getTickets(int order, int sort, String contains) {
        List<TicketEnt> result = tr.findAll();
        result = ticketFilter(result, contains);
        result = ticketSort(order, sort, result);
        logger.debug("Getting tickets");
        System.out.println("Printing all Tickets: ");
        return result;
    }
    public List<TicketEnt> ticketFilter(List<TicketEnt> result, String contains){
        logger.debug("Filtering tickets");
        List<TicketEnt> filteredTickets = new ArrayList<>();
        for (TicketEnt ticket : result){
            if (ticket.getTheme().contains(contains)){
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    public List<TicketEnt> ticketSort(int order, int value, List<TicketEnt> result){
        logger.debug("Sorting tickets");
        if (order == 0 && value == 0) {
            result.sort(new Comparator<TicketEnt>() {
                @Override
                public int compare(TicketEnt o1, TicketEnt o2) {
                    if (o1.getDate().compareTo(o2.getDate()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        else if (order == 1 && value == 0){
            result.sort(new Comparator<TicketEnt>() {
                @Override
                public int compare(TicketEnt o1, TicketEnt o2) {
                    if (o1.getDate().compareTo(o2.getDate()) > 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        }
        else if (order == 0 && value == 1){
            result.sort(new Comparator<TicketEnt>() {
                @Override
                public int compare(TicketEnt o1, TicketEnt o2) {
                    if (o1.getTheme().compareTo(o2.getTheme()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        else if (order == 1 && value == 1){
            result.sort(new Comparator<TicketEnt>() {
                @Override
                public int compare(TicketEnt o1, TicketEnt o2) {
                    if (o1.getTheme().compareTo(o2.getTheme()) > 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        }
        return result;
    }
}
