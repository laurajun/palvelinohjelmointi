<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% if (session.getAttribute("username") != null) { %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css"> 
<meta charset="utf-8">
<title>Vaalikone - Logged in</title>
</head>
<body>
<div class="header">
		<h1>Vaalikone</h1>
	</div>
    <div class="action" style="text-align: center">
        <h1>Tervetuloa Vaalikoneeseen <b>${username}</b>!</h1>
        <br><br>
        <a href="/ListClaims">Näytä väittämät</a><br><br>
        <a href="TallennaVaittama.jsp">Lisää väittämä</a><br><br>
        <a href="/logout">Logout</a>
    </div>
    <div class="footer">
		<p>&copy; Vaalikone. All rights reserved.</p>
	</div>
</body>
</html>
<% } else {%>
    <p> Not logged in </p>
<% } %>
