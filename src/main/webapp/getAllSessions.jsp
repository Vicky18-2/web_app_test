<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
    <c:forEach var="session" items="${sessions}">
    <ui>
        <li> Session id: ${session.idSession} <a href="/getSession?idSession=${session.idSession}"> Details </a> </li>
        <li> Session Date: ${session.sessionDate}</li>
        <li> Session Time: ${session.sessionTime}</li>
        <li> Hall id: ${session.hall.idHall}</li>
        <li> Film name: ${session.film.title}</li>
    </ui>
    <br>
</div>
</c:forEach></body>

<a href="/insertSession"> Insert </a>
</html>
