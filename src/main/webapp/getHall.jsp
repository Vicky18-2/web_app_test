<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<body>
<div align="left">
    <ui>
        <li> Hall id: ${hall.idHall} </li>
        <li> Hall type: ${hall.hallType}</li>
        <li> Column quantity: ${hall.columnQuantity}</li>
        <li> Seat quantity: ${hall.seatQuantity}</li>
    </ui>
    <br>
</div>
</body>

<a href="/updateHall?idHall=${hall.idHall}">Update</a>
<a href="/deleteHall?idHall=${hall.idHall}">Delete</a>
</html>