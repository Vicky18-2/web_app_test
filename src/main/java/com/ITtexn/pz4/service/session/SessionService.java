package com.ITtexn.pz4.service.session;

import com.ITtexn.pz4.service.film.Film;
import com.ITtexn.pz4.service.hall.Hall;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface SessionService {

     @WebMethod
     List<Session> getAllSessions();

     @WebMethod
     Session getSession(int idSession);

     @WebMethod
     void insertSession(int idSession, String sessionDate, String sessionTime, Hall hall, Film film);

     @WebMethod
     void updateSession(int idSession, String sessionDate,String sessionTime, Hall hall, Film film);

     @WebMethod
     void deleteSession(int idSession);

     @WebMethod
     int countSession();
}
