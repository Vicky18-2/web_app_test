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

@WebServlet(
        name = "GetFilm",
        urlPatterns = {"/getFilm"}
)

public class GetFilm extends HttpServlet {


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            URL urlFilm = new URL("http://localhost:7777/film?wsdl");
            FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
            FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

            Film film = new Film();
            film.setIdFilm(Integer.parseInt(req.getParameter("idFilm")));
            film = filmServiceProxy.getFilm(film.getIdFilm());

            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getFilm.jsp");
            req.setAttribute("film", film);
            requestDispatcher.forward(req,resp);


        }

    }

