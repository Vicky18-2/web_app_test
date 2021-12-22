<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update hall</title>
    <%--    <link href="css/default.css" rel="stylesheet">--%>
</head>
<body>
<form method="post" action="updateHall">
    <h3> Id hall</h3>
    <input name="idHall" type="text" required value="${hall.idHall}">
    <h3> Hall type </h3>
    <input name="hallType" type="text" required value="${hall.hallType}">
    <h3> Column Quantity </h3>
    <input name="columnQuantity" type="text" required value="${hall.columnQuantity}">
    <h3> Seat Quantity </h3>
    <input name="seatQuantity" type="text" required value="${hall.seatQuantity}">
    <input type="submit">
</form>
</body>
</html>