<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<ui>
    <li> Film id: ${film.idFilm} </li>
    <li> ${film.title}</li>
    <li> ${film.director}</li>
    <li> ${film.filmDuration}</li>
    <li> ${film.description12}</li>
    <li> ${film.genre}</li>
    <li> ${film.language}</li>
</ui>
<br>
</body>
<a href="/updateFilm?idFilm=${film.idFilm}">Update</a>
<a href="/deleteFilm?idFilm=${film.idFilm}">Delete</a>
</html>