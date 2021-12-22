package com.ITtexn.pz4.servlets.ticket;

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

@WebServlet(
        name = "GetTicket",
        urlPatterns = {"/getTicket"}
)
public class GetTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlTicket = new URL("http://localhost:7777/ticket?wsdl");
        TicketServiceImplementService ticketServiceImplementService = new TicketServiceImplementService(urlTicket);
        TicketService ticketService= ticketServiceImplementService.getTicketServiceImplementPort();

        Ticket ticket = new Ticket();
        ticket.setId(Integer.parseInt(req.getParameter("idTicket")));
        ticket = ticketService.getTicket(ticket.getId());

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getTicket.jsp");
        req.setAttribute("ticket", ticket);
        requestDispatcher.forward(req,resp);
    }
}
