package com.ITtexn.pz4.servlets.ticket;

import com.ITtexn.pz4.client.film_cl.Film;
import com.ITtexn.pz4.client.film_cl.FilmService;
import com.ITtexn.pz4.client.film_cl.FilmServiceImplementService;
import com.ITtexn.pz4.client.hall_cl.Hall;
import com.ITtexn.pz4.client.hall_cl.HallService;
import com.ITtexn.pz4.client.hall_cl.HallServiceImplementService;
import com.ITtexn.pz4.client.session_cl.Session;
import com.ITtexn.pz4.client.session_cl.SessionService;
import com.ITtexn.pz4.client.session_cl.SessionServiceImplementService;
import com.ITtexn.pz4.client.ticket_cl.Ticket;
import com.ITtexn.pz4.client.ticket_cl.TicketService;
import com.ITtexn.pz4.client.ticket_cl.TicketServiceImplementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.List;


@WebServlet(
        name = "InsertTicket",
        urlPatterns = {"/insertTicket"}
)

public class InsertTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlSession = new URL("http://localhost:7777/session?wsdl");
        SessionServiceImplementService sessionServiceImplementService = new SessionServiceImplementService(urlSession);
        SessionService sessionService= sessionServiceImplementService.getSessionServiceImplementPort();

        List<Session> session = sessionService.getAllSessions();
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/insertTicket.jsp");
        req.setAttribute("session", session);
        requestDispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlTicket = new URL("http://localhost:7777/ticket?wsdl");
        TicketServiceImplementService ticketServiceImplementService = new TicketServiceImplementService(urlTicket);
        TicketService ticketService= ticketServiceImplementService.getTicketServiceImplementPort();

        URL urlSession = new URL("http://localhost:7777/session?wsdl");
        SessionServiceImplementService sessionServiceImplementService = new SessionServiceImplementService(urlSession);
        SessionService sessionService= sessionServiceImplementService.getSessionServiceImplementPort();

        com.ITtexn.pz4.client.ticket_cl.Session session = new  com.ITtexn.pz4.client.ticket_cl.Session();
       Session newSession = sessionService.getSession(Integer.parseInt(req.getParameter("idSession")));

        URL urlHall = new URL("http://localhost:7777/hall?wsdl");
        HallServiceImplementService hallServiceImplementService = new HallServiceImplementService(urlHall);
        HallService hallService= hallServiceImplementService.getHallServiceImplementPort();

        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        com.ITtexn.pz4.client.session_cl.Film newfilm = newSession.getFilm();
        com.ITtexn.pz4.client.ticket_cl.Film film = new com.ITtexn.pz4.client.ticket_cl.Film();
        com.ITtexn.pz4.client.session_cl.Hall newhall = newSession.getHall();
        com.ITtexn.pz4.client.ticket_cl.Hall hall = new com.ITtexn.pz4.client.ticket_cl.Hall();

        film.setIdFilm(newfilm.getIdFilm());
        film.setFilmDuration(newfilm.getFilmDuration());
        film.setDirector(newfilm.getDirector());
        film.setGenre(com.ITtexn.pz4.client.ticket_cl.Genre.valueOf(newfilm.getGenre().toString()));
        film.setDescription12(newfilm.getDescription12());
        film.setTitle(newfilm.getTitle());
        film.setLanguage(newfilm.getLanguage());

        hall.setIdHall(newhall.getIdHall());
        hall.setHallType(newhall.getHallType());
        hall.setColumnQuantity(newhall.getColumnQuantity());
        hall.setSeatQuantity(newhall.getSeatQuantity());

       Ticket ticket = new Ticket();


       session.setIdSession(newSession.getIdSession());
       session.setSessionDate(newSession.getSessionDate());
       session.setFilm(film);
       session.setHall(hall);
       session.setSessionTime(newSession.getSessionTime());

       ticket.setId(Integer.parseInt(req.getParameter("idTicket")));
       ticket.setTicketPrice(Integer.parseInt(req.getParameter("ticketPrice")));
       ticket.setTicketStatus(Boolean.valueOf(req.getParameter("ticketStatus")));
       ticket.setIdSeat(Integer.parseInt(req.getParameter("idSeat")));
       ticket.setIdColumn(Integer.parseInt(req.getParameter("idColumn")));
       ticket.setSession(session);

       ticketService.insertTicket(ticket.getTicketPrice(), ticket.getSession(),  ticket.getId(),ticket.getIdSeat(), ticket.getIdColumn(),ticket.isTicketStatus());
       resp.sendRedirect("getAllTickets");


    }
}
