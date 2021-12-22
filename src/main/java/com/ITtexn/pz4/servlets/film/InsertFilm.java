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
        name = "InsertFilm",
        urlPatterns = {"/insertFilm"}
)

public class InsertFilm extends HttpServlet {
//
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/insertFilm.jsp");
        requestDispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Film film = new Film();

        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        film.setIdFilm(Integer.parseInt(request.getParameter("idFilm")));
        film.setFilmDuration(request.getParameter("filmDuration"));
        film.setDirector(request.getParameter("director"));
        film.setGenre(Genre.valueOf(request.getParameter("genre").toString()));
        film.setDescription12(request.getParameter("description"));
        film.setTitle(request.getParameter("title"));
        film.setLanguage(request.getParameter("language"));

//        int idFilm = Integer.parseInt(request.getParameter("idFilm"));
//        String title = request.getParameter("title");
//        String director = request.getParameter("director");
//        String filmDuration = request.getParameter("filmDuration");
//        String description = request.getParameter("description");
//        Genre genre =  Genre.valueOf(request.getParameter("genre").toString());
//        String language = request.getParameter("language");

        filmServiceProxy.insertFilm(film.getIdFilm(), film.getTitle(), film.getDirector(), film.getFilmDuration(), film.getDescription12(), film.getGenre(), film.getLanguage());
//        filmServiceProxy.insertFilm(idFilm, title, director, filmDuration, description, genre, language);
   //     session.setAttribute("film", film);

        response.sendRedirect("/getAllFilms");
    }
}
