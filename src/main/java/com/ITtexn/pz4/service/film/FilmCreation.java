package com.ITtexn.pz4.service.film;

import com.ITtexn.pz4.service.genre.Genre;

import java.util.ArrayList;
import java.util.List;

public class FilmCreation extends Film {

    private List<Film> filmList;



    public FilmCreation() {
        filmList = new ArrayList<>();
        filmList.add(new Film(1, "Title","TOM", "01:01:01", "description", Genre.fromValue("Comedy"), "RU"));
    }
    public List<Film> getAllFilmList() {
        return filmList;
    }

    public Film getFilm(int id_film) {
        for (Film film : filmList) {
            if (film.getId_film() == id_film) {
                return film;
            }
        }

        return null;
    }

    public void updateFilm(int id_film, String title,String director, String filmDuration, String description, Genre genre, String language) {
        for (Film film : filmList) {
            if (film.getId_film() == id_film) {
                film.setTitle(title);
                film.setLanguage(language);
                film.setFilmDuration(filmDuration);
                film.setDirector(director);
                film.setDescription12(description);
                film.setGenre(genre);
            }
        }
    }

    public void insertFilm(int id_film, String title,String director, String filmDuration, String description, Genre genre, String language){
        Film film= new Film(id_film, title, director,filmDuration, description, genre, language);
        filmList.add(film);
    }

    public void deleteFilm(int id_film){
       int index = filmList.lastIndexOf(getFilm(id_film));
       filmList.remove(index);
    }

    public int count() {
        return filmList.size();
    }

}
