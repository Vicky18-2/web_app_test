package com.ITtexn.pz4.servlets.film;

import com.ITtexn.pz4.client.film_cl.Film;
import com.ITtexn.pz4.client.film_cl.FilmService;
import com.ITtexn.pz4.client.film_cl.FilmServiceImplementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

@WebServlet(
        name = "DeleteFilm",
        urlPatterns = {"/deleteFilm"}
)

public class DeleteFilm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  int id = Integer.parseInt(req.getParameter("idFilm"));
        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        Film film = new Film();
        film.setIdFilm(Integer.parseInt(req.getParameter("idFilm")));
        filmServiceProxy.deleteFilm(film.getIdFilm());
        resp.sendRedirect("/getAllFilms");
    }
}
