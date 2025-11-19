<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<br/>
<form action="login" method="post" style="display: flex; flex-direction: column; width: 33%">
    <label for="user">Username</label>
    <input type="text" name="username" id="user">
    <label for="password">Password</label>
    <input type="password" name="password" id="password">
    <button type="submit">Log in</button>
</form>

</body>
</html>