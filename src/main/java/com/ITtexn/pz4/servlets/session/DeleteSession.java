package com.ITtexn.pz4.servlets.session;





import com.ITtexn.pz4.client.session_cl.Session;
import com.ITtexn.pz4.client.session_cl.SessionService;
import com.ITtexn.pz4.client.session_cl.SessionServiceImplementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet (
        name = "DeleteSession",
        urlPatterns = {"/deleteSession"}
)
public class DeleteSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlSession = new URL("http://localhost:7777/session?wsdl");
        SessionServiceImplementService sessionServiceImplementService = new SessionServiceImplementService(urlSession);
        SessionService sessionService= sessionServiceImplementService.getSessionServiceImplementPort();

        Session session = new Session();
        session.setIdSession(Integer.parseInt(req.getParameter("idSession")));
        sessionService.deleteSession(session.getIdSession());
        resp.sendRedirect("/getAllSessions");
    }
}
