package com.ITtexn.pz4.servlets.hall;

import com.ITtexn.pz4.client.hall_cl.Hall;
import com.ITtexn.pz4.client.hall_cl.HallService;
import com.ITtexn.pz4.client.hall_cl.HallServiceImplementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet (
        name = "DeleteHall",
        urlPatterns = {"/deleteHall"}
)

public class DeleteHall extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlHall = new URL("http://localhost:7777/hall?wsdl");
        HallServiceImplementService hallServiceImplementService = new HallServiceImplementService(urlHall);
        HallService hallService= hallServiceImplementService.getHallServiceImplementPort();

        Hall hall = new Hall();
        hall.setIdHall(Integer.parseInt(req.getParameter("idHall")));
        hallService.deleteHall(hall.getIdHall());
        resp.sendRedirect("/getAllHalls");
    }
}
