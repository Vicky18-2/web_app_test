<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update films</title>
    <%--    <link href="css/default.css" rel="stylesheet">--%>
</head>
<body>
<form method="post" action="updateFilm">
    <h3> Id film</h3>
    <input name="idFilm" type="text" required value="${film.idFilm}">
    <h3> Title </h3>
    <input name="title" type="text" required value="${film.title}">
    <h3> Director </h3>
    <input name="director" type="text" required value="${film.director}">
    <h3> Film Duration </h3>
    <input name="filmDuration" type="text" required value="${film.filmDuration}">
    <h3> Description </h3>
    <input name="description" type="text" required value="${film.description12}">
    <h3> Genre </h3>
    <input name="genre" type="text" required value="${film.genre}">
    <h3> Language </h3>
    <input name="language" type="text" required value="${film.language}">
    <input type="submit">

    <%--    ${film.title}--%>
    <%--     ${film.director}--%>
    <%--     ${film.filmDuration}--%>
    <%--     ${film.description}--%>
    <%--     ${film.genre}--%>
    <%--     ${film.language}--%>




</form>
</body>
</html>