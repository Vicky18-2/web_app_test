package com.ITtexn.pz4.service.ticket;

import com.ITtexn.pz4.service.film.Film;
import com.ITtexn.pz4.service.hall.Hall;
import com.ITtexn.pz4.service.session.Session;

import java.util.ArrayList;
import java.util.List;

public class TicketCreation {

    private List<Ticket> ticketList;

    public TicketCreation(){
        ticketList = new ArrayList<>();
        Session session= new Session();
        ticketList.add(new Ticket(200,session,1,4,5,false));
    }

    public List<Ticket> getAllTickets(){
        return ticketList;
    };

    public Ticket getTicket(int idTicket){
        for(Ticket ticket:ticketList){
            if(ticket.getId() == idTicket ){
                return ticket;
            }
        }
        return  null;
    };

    public void insertTicket(int ticketPrice, Session session, int idTicket, int idSeat, int idColumn, boolean ticketStatus ){
        Ticket ticket = new Ticket(ticketPrice,session, idTicket,idSeat,idColumn,ticketStatus);
        ticketList.add(ticket);
    };

    public void updateTicket(int ticketPrice, Session session,  int idTicket,int idSeat, int idColumn, boolean ticketStatus ){
        for(Ticket ticket: ticketList){
            if(ticket.getId() == idTicket) {
                ticket.setTicketPrice(ticketPrice);
                ticket.setSession(session);
                ticket.setTicketStatus(ticketStatus);
                ticket.setIdColumn(idColumn);
                ticket.setIdSeat(idSeat);
            }
        }
    };

    public void deleteTicket(int idTicket){
        int index=ticketList.lastIndexOf(getTicket(idTicket));
        ticketList.remove(index);
    };

    public int countTicket(){
        return ticketList.size();
    };

}
