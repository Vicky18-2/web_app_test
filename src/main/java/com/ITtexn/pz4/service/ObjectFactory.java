
package com.ITtexn.pz4.service;

import com.ITtexn.pz4.service.hall.Hall;
import com.ITtexn.pz4.service.session.Session;
import com.ITtexn.pz4.service.ticket.Ticket;
import com.ITtexn.pz4.service.film.Film;

import javax.xml.bind.annotation.XmlRegistry;



@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public Tickets createTickets() {
        return new Tickets();
    }

    public Ticket createTicket() {
        return new Ticket();
    }

    public Session createSession() {
        return new Session();
    }

    public Hall createHall() {
        return new Hall();
    }

    public Film createFilm() {
        return new Film();
    }

}
