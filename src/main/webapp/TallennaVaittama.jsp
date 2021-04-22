<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% if (session.getAttribute("username") != null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone - Väittämän lisäys</title>
</head>
<body>
    <div style="text-align: center">
	 <form action="TallennaVaittama" method="post">
            <label for="vaittama">Väittämä:</label>
            <input type="text" name="vaittama" size="30" />
            <br><br>           
            <button type="submit">Lisää</button>
        </form>
    </div>
</body>
</html>
<% } else {%>
    <p> Not logged in </p>
<% } %>