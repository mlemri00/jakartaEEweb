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
<style>
    #div1{
        display: flex;
        flex-direction: column;
        width: 100%;
        justify-content: center;
        align-items: center;
    }
    #saveForm{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<div id="div1">
<ul>

        <c:forEach var="movie" items="${movies}">
    <li>
    <a href="movies?id=<c:out value='${movie.getId()}'/>"> <c:out value="${movie.getTitle()} ${movie.getYear()}"/></a>
        </c:forEach>
    </li>
</ul>
    <form id="saveForm" action="movies" method="post">
        <input type="hidden" value="post" name="_method">
        <label for="text">Enter movie title</label>
        <input id="text" type="text" name="title">

        <label for="desc">Enter movie description</label>
        <input id="desc" type="text" name="description">

        <label for="year">Enter movie year</label>
        <input id="year" type="text" name="year">
        <button type="submit">Save</button>
    </form>
</div>



</body>
</html>
