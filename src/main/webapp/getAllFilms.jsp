<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
<c:forEach var="film" items="${films}">
    <ui>
        <li> Film id: ${film.idFilm} <a href="/getFilm?idFilm=${film.idFilm}"> Details </a> </li>
        <li> Title: ${film.title}</li>
        <li> Director: ${film.director}</li>
        <li> Film duration: ${film.filmDuration}</li>
        <li> Description: ${film.description12}</li>
        <li> Genre: ${film.genre}</li>
        <li> Language: ${film.language}</li>
    </ui>
    <br>
</div>
</c:forEach></body>

<a href="/insertFilm"> Insert </a>
</html>