package com.ITtexn.pz4.service.ticket;

import com.ITtexn.pz4.service.film.Film;
import com.ITtexn.pz4.service.hall.Hall;
import com.ITtexn.pz4.service.session.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TicketService {

    @WebMethod
    List<Ticket> getAllTickets();

    @WebMethod
    Ticket getTicket(int idTicket);

    @WebMethod
    void insertTicket(int ticketPrice, Session session, int idTicket, int idSeat, int idColumn, boolean ticketStatus );

    @WebMethod
    void updateTicket(int ticketPrice, Session session, int idTicket, int idSeat, int idColumn, boolean ticketStatus  );

    @WebMethod
    void deleteTicket(int idTicket);

    @WebMethod
    int countTicket();
}
