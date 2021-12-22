<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
    <c:forEach var="ticket" items="${tickets}">
    <ui>
        <li> Ticket id: ${ticket.id} <a href="/getTicket?idTicket=${ticket.id}"> Details </a> </li>
        <li> Ticket Price: ${ticket.ticketPrice}</li>
        <li> Id Seat: ${ticket.idSeat}</li>
        <li> Id column: ${ticket.idColumn}</li>
        <li> ticket status: ${ticket.ticketStatus}</li>
        <li> Session date: ${ticket.session.sessionDate}</li>
        <li> Session time: ${ticket.session.sessionTime}</li>
        <li> Film name: ${ticket.session.film.title}</li>
    </ui>
    <br>
</div>
</c:forEach></body>

<a href="/insertTicket"> Insert </a>
</html>
