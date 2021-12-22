package com.ITtexn.pz4.service.film;

import com.ITtexn.pz4.service.genre.Genre;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import javax.inject.Inject;


@WebService(endpointInterface = "com.ITtexn.pz4.service.film.FilmService")

public class FilmServiceImplement implements FilmService {

    @Inject
    protected FilmCreation filmCreation;

    public FilmServiceImplement() {
        this.filmCreation = new FilmCreation();
    }

    @WebMethod
    public Film getFilm(int id_film) {
        return filmCreation.getFilm(id_film);
    }

    @WebMethod
    public void updateFilm(int id_film, String title, String director, String filmDuration, String description, Genre genre, String language) {
        filmCreation.updateFilm(id_film,title,director,filmDuration,description,genre,language);
    }

    @WebMethod
    public void deleteFilm(int id_film) {
        filmCreation.deleteFilm(id_film);
    }

    @WebMethod
    public void insertFilm(int id_film, String title, String director,String filmDuration, String description, Genre genre, String language) {
         filmCreation.insertFilm(id_film,title,director,filmDuration,description,genre,language);
    }

    @WebMethod
    public List<Film> getAllFilms() {
        return filmCreation.getAllFilmList();
    }

    @WebMethod
    public int countFilms() {
        return filmCreation.count();
    }

}
