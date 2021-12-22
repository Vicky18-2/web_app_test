package com.ITtexn.pz4.servlets.session;







import com.ITtexn.pz4.client.hall_cl.Hall;
import com.ITtexn.pz4.client.session_cl.Film;
import com.ITtexn.pz4.client.session_cl.Session;
import com.ITtexn.pz4.client.session_cl.SessionService;
import com.ITtexn.pz4.client.session_cl.SessionServiceImplementService;

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
        name = "GetAllSessions",
        urlPatterns = {"/getAllSessions"}
)
public class GetAllSessions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlSession = new URL("http://localhost:7777/session?wsdl");
        SessionServiceImplementService sessionServiceImplementService = new SessionServiceImplementService(urlSession);
        SessionService sessionService= sessionServiceImplementService.getSessionServiceImplementPort();

        Film film = new Film();
        Hall hall = new Hall();
        List<Session> session = sessionService.getAllSessions();
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getAllSessions.jsp");
        req.setAttribute("sessions", session);
        requestDispatcher.forward(req,resp);
    }
}
