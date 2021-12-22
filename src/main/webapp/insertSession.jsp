<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert films</title>
    <%--    <link href="css/default.css" rel="stylesheet">--%>
</head>
<body>
<form method="post" action="insertSession">
    <h3> Session id:</h3>
    <input name="idSession" type="text" required>
    <h3> Session Date: </h3>
    <input name="sessionDate" type="text" required>
    <h3> Session Time: </h3>
    <input name="sessionTime" type="text" required>
    <h3> Hall id: </h3>
    <select name="idHall" required>
        <c:forEach var="hall" items="${hall}">
            <option value="${hall.idHall}">${hall.idHall}</option>
        </c:forEach>
    </select>
    <h3> Film name: </h3>
    <select name="idFilm" required>
        <c:forEach var="film" items="${film}">
            <option value="${film.idFilm}">${film.title}</option>
        </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>