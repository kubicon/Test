package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.TicketVO;
import com.aspectworks.active24.api.rest.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

@Service
public class TicketServiceImpl implements TicketService{
    static ArrayList<TicketVO> tickets = new ArrayList<>();
    public void createTicket(TicketVO ticket){
        tickets.add(ticket);
    }

    public void deleteTicket(int ticketID){
        for (TicketVO ticket: tickets){
            if (ticket.getTicketID() == ticketID){
                tickets.remove(ticket);
            }
        }
    }
    public List<TicketVO> getTickets() {
        return tickets;
    }
    public List<TicketVO> ticketSort(int order, int value){
        if (order == 0 && value == 0) {
            tickets.sort(new Comparator<TicketVO>() {
                @Override
                public int compare(TicketVO o1, TicketVO o2) {
                    if (o1.getDate().compareTo(o2.getDate()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        else if (order == 1 && value == 0){
            tickets.sort(new Comparator<TicketVO>() {
                @Override
                public int compare(TicketVO o1, TicketVO o2) {
                    if (o1.getDate().compareTo(o2.getDate()) > 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        }
        else if (order == 0 && value == 1){
            tickets.sort(new Comparator<TicketVO>() {
                @Override
                public int compare(TicketVO o1, TicketVO o2) {
                    if (o1.getTheme().compareTo(o2.getTheme()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        else if (order == 1 && value == 1){
            tickets.sort(new Comparator<TicketVO>() {
                @Override
                public int compare(TicketVO o1, TicketVO o2) {
                    if (o1.getTheme().compareTo(o2.getTheme()) > 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        }
        return tickets;
    }
}
