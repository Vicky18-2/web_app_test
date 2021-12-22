package com.ITtexn.pz4.servlets.hall;

import com.ITtexn.pz4.client.hall_cl.Hall;
import com.ITtexn.pz4.client.hall_cl.HallService;
import com.ITtexn.pz4.client.hall_cl.HallServiceImplementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet (
        name = "InsertHall",
        urlPatterns = {"/insertHall"}
)

public class InsertHall extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/insertHall.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlHall = new URL("http://localhost:7777/hall?wsdl");
        HallServiceImplementService hallServiceImplementService = new HallServiceImplementService(urlHall);
        HallService hallService= hallServiceImplementService.getHallServiceImplementPort();

        Hall hall = new Hall();

        hall.setIdHall(Integer.parseInt(req.getParameter("idHall")));
        hall.setHallType(req.getParameter("hallType"));
        hall.setColumnQuantity(Integer.parseInt(req.getParameter("columnQuantity")));
        hall.setSeatQuantity(Integer.parseInt(req.getParameter("seatQuantity")));

        hallService.insertHall(hall.getIdHall(), hall.getHallType(), hall.getColumnQuantity(), hall.getSeatQuantity());
        resp.sendRedirect("/getAllHalls");
    }



}
