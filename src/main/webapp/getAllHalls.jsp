<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
    <c:forEach var="hall" items="${halls}">
    <ui>
        <li> Hall id: ${hall.idHall} <a href="/getHall?idHall=${hall.idHall}"> Details </a> </li>
        <li> Hall type: ${hall.hallType}</li>
        <li> Column quantity: ${hall.columnQuantity}</li>
        <li> Seat quantity: ${hall.seatQuantity}</li>
    </ui>
    <br>
</div>
</c:forEach></body>

<a href="/insertHall"> Insert </a>
</html>
