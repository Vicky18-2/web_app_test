package com.ITtexn.pz4.servlets.film;


import com.ITtexn.pz4.client.film_cl.Film;
import com.ITtexn.pz4.client.film_cl.FilmService;
import com.ITtexn.pz4.client.film_cl.FilmServiceImplementService;
import com.ITtexn.pz4.client.film_cl.Genre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

@WebServlet(
        name = "UpdateFilm",
        urlPatterns = {"/updateFilm"}
)
public class UpdateFilm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        Film film = new Film();
        film.setIdFilm(Integer.parseInt(req.getParameter("idFilm")));
        film = filmServiceProxy.getFilm(film.getIdFilm());

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/updateFilm.jsp");
        req.setAttribute("film", film);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
       // Film film = new Film();

        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        Film newFilm= new Film.Builder().id(Integer.parseInt(req.getParameter("idFilm")))
                .title(req.getParameter("title"))
                .director(req.getParameter("director"))
                .filmDuration(req.getParameter("filmDuration"))
                .description(req.getParameter("description"))
                .genre(Genre.valueOf(req.getParameter("genre").toString()))
                .language(req.getParameter("language")).build();

        //Film oldFilm = filmServiceProxy.getFilm(Integer.parseInt(req.getParameter("idFilm")));
        filmServiceProxy.updateFilm(newFilm.getIdFilm(), newFilm.getTitle(), newFilm.getDirector(), newFilm.getFilmDuration(), newFilm.getDescription12(), newFilm.getGenre(), newFilm.getLanguage());

//        film.setIdFilm(Integer.parseInt(req.getParameter("idFilm")));
//        film.setFilmDuration(req.getParameter("filmDuration"));
//        film.setDirector(req.getParameter("director"));
//        film.setGenre(Genre.valueOf(req.getParameter("genre").toString()));
//        film.setDescription12(req.getParameter("description"));
//        film.setTitle(req.getParameter("title"));
//        film.setLanguage(req.getParameter("language"));


     //   filmServiceProxy.updateFilm(film.getIdFilm(), film.getTitle(), film.getDirector(), film.getFilmDuration(), film.getDescription12(), film.getGenre(), film.getLanguage());

        resp.sendRedirect("/getFilm?idFilm=" + newFilm.getIdFilm());
    }
}
