<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
    <ui>
        <li> Ticket id: ${ticket.id} </li>
        <li> Ticket Price: ${ticket.ticketPrice}</li>
        <li> Id Seat: ${ticket.idSeat}</li>
        <li> Id column: ${ticket.idColumn}</li>
        <li> ticket status: ${ticket.ticketStatus}</li>
        <li> Session date: ${ticket.session.sessionDate}</li>
        <li> Session time: ${ticket.session.sessionTime}</li>
    </ui>
    <br>
</div>
</body>

<a href="/updateTicket?idTicket=${ticket.id}">Update</a>
<a href="/deleteTicket?idTicket=${ticket.id}">Delete</a>
</html>
