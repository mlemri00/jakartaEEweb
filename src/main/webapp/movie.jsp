
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: lemr
  Date: 13/11/25
  Time: 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie</title>
</head>
<body>
<div>
    <h1><c:out  value="${movie.getTitle()}"/></h1>
    <p><c:out value="${movie.getYear()}"/></p>
    <p><c:out  value="${movie.getDescription()}"/></p>
</div>

</body>
</html>
