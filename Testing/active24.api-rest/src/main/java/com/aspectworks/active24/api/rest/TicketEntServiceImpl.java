package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TicketEnt;
import com.aspectworks.active24.api.rest.vo.TicketVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketEntServiceImpl {
    static ArrayList<TicketEnt> tickets = new ArrayList<>();
    public void createTicket(TicketVO ticket){
        TicketEnt ticketEnt = new TicketEnt();
        ticketEnt.setDate(ticket.getDate());
        ticketEnt.setTheme(ticket.getTheme());
        ticketEnt.setTicketID(ticket.getTicketID());
        tickets.add(ticketEnt);

    }

    public void deleteTicket(int ticketID){
        for (TicketEnt ticket: tickets){
            if (ticket.getTicketID() == ticketID){
                tickets.remove(ticket);
            }
        }
    }
    public void createComment(CommentVO comment, long ticketid){
        for (TicketEnt ticket : tickets){
            if (ticket.getTicketID() == ticketid){
                ticket.addComment(comment);
                System.out.println("New comment created: " + comment + "in ticket with id" + ticketid);
            }
        }
    }
    public List<CommentVO> getComments(long ticketid){
        for (TicketEnt ticket : tickets){
            if (ticket.getTicketID() == ticketid){
                return ticket.getComments();
            }
        }
        return null;
    }
    public List<TicketEnt> getTickets() {
        return tickets;
    }
}
