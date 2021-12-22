package com.ITtexn.pz4.servlets.film;

import com.ITtexn.pz4.client.film_cl.Film;
import com.ITtexn.pz4.client.film_cl.FilmService;
import com.ITtexn.pz4.client.film_cl.FilmServiceImplementService;

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
            name = "GetAllFilms",
            urlPatterns = {"/getAllFilms"}
    )

public class GetAllFilms extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        List<Film> films = filmServiceProxy.getAllFilms();
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getAllFilms.jsp");
        req.setAttribute("films", films);
        requestDispatcher.forward(req,resp);
    }

}
