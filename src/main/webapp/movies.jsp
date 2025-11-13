<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: lemr
  Date: 9/11/25
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
        <c:forEach var="movie" items="${movies}">
    <li>
        <c:out value="${movie.getTitle()} ${movie.getYear()}"/>
    </li>
        </c:forEach>

</ul>
</body>
</html>
