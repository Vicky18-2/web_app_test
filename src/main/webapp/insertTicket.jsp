<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert tickets</title>
    <%--    <link href="css/default.css" rel="stylesheet">--%>
</head>
<body>
<form method="post" action="insertTicket">
    <h3> Ticket id:</h3>
    <input name="idTicket" type="text" required>
    <h3> Ticket Price: </h3>
    <input name="ticketPrice" type="text" required>
    <h3> seat id: </h3>
    <input name="idSeat" type="text" required>
    <h3> column id: </h3>
    <input name="idColumn" type="text" required>
    <h3> ticket status: </h3>
    <input name="ticketStatus" type="text" required>
    <h3> Session </h3>
    <select name="idSession" required>
        <c:forEach var="session" items="${session}">
        <option value="${session.idSession}">${session.film.title} - ${session.sessionDate} - ${session.sessionTime}</option>
            </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>