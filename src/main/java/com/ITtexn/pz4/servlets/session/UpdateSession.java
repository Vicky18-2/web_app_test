package com.ITtexn.pz4.servlets.session;

import com.ITtexn.pz4.client.film_cl.Film;
import com.ITtexn.pz4.client.film_cl.FilmService;
import com.ITtexn.pz4.client.film_cl.FilmServiceImplementService;
import com.ITtexn.pz4.client.hall_cl.Hall;
import com.ITtexn.pz4.client.hall_cl.HallService;
import com.ITtexn.pz4.client.hall_cl.HallServiceImplementService;
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
        name = "UpdateSession",
        urlPatterns = {"/updateSession"}
)
public class UpdateSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlSession = new URL("http://localhost:7777/session?wsdl");
        SessionServiceImplementService sessionServiceImplementService = new SessionServiceImplementService(urlSession);
        SessionService sessionService= sessionServiceImplementService.getSessionServiceImplementPort();

        URL urlHall = new URL("http://localhost:7777/hall?wsdl");
        HallServiceImplementService hallServiceImplementService = new HallServiceImplementService(urlHall);
        HallService hallService= hallServiceImplementService.getHallServiceImplementPort();

        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();


        List<Film> film = filmServiceProxy.getAllFilms();
        List<Hall> hall = hallService.getAllHalls();
        Session session = new Session();
        session.setIdSession(Integer.parseInt(req.getParameter("idSession")));
        session = sessionService.getSession(session.getIdSession());

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/updateSession.jsp");
        req.setAttribute("film", film);
        req.setAttribute("hall", hall);
        req.setAttribute("session", session);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL urlSession = new URL("http://localhost:7777/session?wsdl");
        SessionServiceImplementService sessionServiceImplementService = new SessionServiceImplementService(urlSession);
        SessionService sessionService= sessionServiceImplementService.getSessionServiceImplementPort();

        URL urlHall = new URL("http://localhost:7777/hall?wsdl");
        HallServiceImplementService hallServiceImplementService = new HallServiceImplementService(urlHall);
        HallService hallService= hallServiceImplementService.getHallServiceImplementPort();

        URL urlFilm = new URL("http://localhost:7777/film?wsdl");
        FilmServiceImplementService filmServiceImplementService = new FilmServiceImplementService(urlFilm);
        FilmService filmServiceProxy = filmServiceImplementService.getFilmServiceImplementPort();

        com.ITtexn.pz4.client.session_cl.Film film = new com.ITtexn.pz4.client.session_cl.Film();
        Film newfilm = filmServiceProxy.getFilm(Integer.parseInt(req.getParameter("idFilm")));
        com.ITtexn.pz4.client.session_cl.Hall hall = new com.ITtexn.pz4.client.session_cl.Hall();
        Hall newhall = hallService.getHall(Integer.parseInt(req.getParameter("idHall")));

        Session session = new Session();

        film.setIdFilm(newfilm.getIdFilm());
        film.setFilmDuration(newfilm.getFilmDuration());
        film.setDirector(newfilm.getDirector());
        film.setGenre(com.ITtexn.pz4.client.session_cl.Genre.valueOf(newfilm.getGenre().toString()));
        film.setDescription12(newfilm.getDescription12());
        film.setTitle(newfilm.getTitle());
        film.setLanguage(newfilm.getLanguage());

        hall.setIdHall(newhall.getIdHall());
        hall.setHallType(newhall.getHallType());
        hall.setColumnQuantity(newhall.getColumnQuantity());
        hall.setSeatQuantity(newhall.getSeatQuantity());

        session.setIdSession(Integer.parseInt(req.getParameter("idSession")));
        session.setSessionDate(req.getParameter("sessionDate"));
        session.setSessionTime(req.getParameter("sessionTime"));
        session.setFilm(film);
        session.setHall(hall);

        sessionService.updateSession(session.getIdSession(),session.getSessionDate(),session.getSessionTime(),session.getHall(),session.getFilm());
        resp.sendRedirect("/getSession?idSession=" + session.getIdSession());
    }
}
