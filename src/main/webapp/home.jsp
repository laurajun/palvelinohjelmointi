<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% if (session.getAttribute("username") != null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone - Logged in</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Tervetuloa Vaalikoneeseen <b>${username}</b>!</h1>
        <br><br>
        <a href="/ListClaims">Näytä väittämät</a><br><br>
        <a href="/logout">Logout</a>
    </div>
</body>
</html>
<% } else {%>
    <p> Not logged in </p>
<% } %>
