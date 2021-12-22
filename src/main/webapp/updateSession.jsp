<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
</head>
<body>
<form method="post" action="updateSession">
    <h3> Session id:</h3>
    <input name="idSession" type="text" required value="${session.idSession}">
    <h3> Session Date: </h3>
    <input name="sessionDate" type="text" required value="${session.sessionDate}">
    <h3> Session Time: </h3>
    <input name="sessionTime" type="text" required value="${session.sessionTime}">
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

