package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TicketVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.Ticket;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    public TicketServiceImpl ticketService;
    @Autowired
    public TicketEntServiceImpl ticketEntService;
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTicket(@RequestBody TicketVO ticket){
        ticket.setDate(java.util.Calendar.getInstance().getTime());
        ticketService.createTicket(ticket);
        ticketEntService.createTicket(ticket);
        System.out.println("New ticket created: " + ticket);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{ticketid}")
    public void deleteTicket(@PathVariable("ticketid") int ticketID){
        ticketService.deleteTicket(ticketID);
        ticketEntService.deleteTicket(ticketID);
        System.out.println("Deleting ticket with name: " + ticketID);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketVO> getAllTickets(@RequestParam(value = "order", defaultValue = "1") int order, @RequestParam(value = "sort", defaultValue = "0") int sort){
        ticketService.ticketSort(order, sort);
        System.out.println(ticketService.getTickets());
        return ticketService.getTickets();
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{ticketid}/comments")
    public void createComment(@RequestBody CommentVO comment, @PathVariable("ticketid") long ticketid){
        ticketEntService.createComment(comment, ticketid);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{ticketid}/comments")
    public List<CommentVO> getComments(@PathVariable("ticketid") long ticketid){
        return ticketEntService.getComments(ticketid);
    }
    /*
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = {"/order", "/value"})
    public List<TicketVO> sortTickets(@RequestParam("order") int order, @RequestParam("value") int value){
        return ticketService.ticketSort(order, value);
    }*/
}
