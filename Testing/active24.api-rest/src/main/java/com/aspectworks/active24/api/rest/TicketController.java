package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TicketEnt;
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
        ticketEntService.createTicket(ticket);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{ticketid}")
    public void deleteTicket(@PathVariable("ticketid") int ticketID){
        //ticketService.deleteTicket(ticketID);
        ticketEntService.deleteTicket(ticketID);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketEnt> getAllTickets(@RequestParam(value = "order", defaultValue = "0") int order, @RequestParam(value = "sort", defaultValue = "0") int sort, @RequestParam(value = "contains", defaultValue = "") String contains){
        return ticketEntService.getTickets(order, sort, contains);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{ticketid}/comments")
    public void createComment(@RequestBody CommentVO comment, @PathVariable("ticketid") long ticketid){
        ticketEntService.createComment(comment, ticketid);
    }/*
    @RequestMapping(method = RequestMethod.DELETE, value = "/{ticketid}/comments/{commentid}")
    public void deleteTicket(@PathVariable("ticketid") int ticketid, @PathVariable("commentid") int commentid){
        ticketEntService.deleteComment(ticketid, commentid);
    }*/
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
