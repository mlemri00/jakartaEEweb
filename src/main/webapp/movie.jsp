
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
<style>
    #updateForm{
        display: flex;
        flex-direction: column;
        width: 30%;
    }
    .main{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

</style>
<head>
    <title>Movie</title>
</head>
<body>
<div class="main">
<div>
   <form action="movies" method="post" id="updateForm">
       <input type="hidden" name="_method" value="put">
       <input type="hidden" name="id" value="<c:out value="${movie.getId()}"/>">
       <label for="title">Title</label>
       <input id="title" type="text" name="title" value="<c:out value="${movie.getTitle()}"/>">
       <label for="description">Description</label>
       <input id="description" type="text" name="description" value="<c:out value="${movie.getDescription()}"/>">
       <label for="year">Year</label>
       <input id="year" type="number" name="year" value="<c:out value="${movie.getYear()}"/>">

       <button style="width: 40px" type="submit">Edit</button>
   </form>

</div>
<h2>Comments</h2>
<ol>
    <c:out value="${movie.getComments()}" />
    <c:forEach var="comment" items="${movie.getComments()}">
        <li><c:out value="${comment.getCommentText()} "/></li>
    </c:forEach>

</ol>


<form action="movies" method="post">
<input type="hidden" value="delete" name="_method">
    <input type="hidden" name="id" value="<c:out value="${movie.getId()}"/>">
    <button type="submit">Delete</button>
</form>
</div>
</body>
</html>
