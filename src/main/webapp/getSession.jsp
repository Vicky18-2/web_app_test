<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
    <ui>
        <li> Session id: ${session.idSession}  </li>
        <li> Session Date: ${session.sessionDate}</li>
        <li> Session Time: ${session.sessionTime}</li>
        <li> Hall id: ${session.hall.idHall}</li>
        <li> Film name: ${session.film.title}</li>
    </ui>
    <br>
</div>
</body>

<a href="/updateSession?idSession=${session.idSession}">Update</a>
<a href="/deleteSession?idSession=${session.idSession}">Delete</a>
</html>