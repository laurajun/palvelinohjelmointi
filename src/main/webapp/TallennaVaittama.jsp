<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% if (session.getAttribute("username") != null) { %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css"> 
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Vaalikone - Väittämän lisäys</title>
</head>
<body>
   <div class="header">
		<h1>Vaalikone</h1>
	</div>
    
    <div class="action">
        <h2>Lisää uusi väittämä</h2>
	 <form action="TallennaVaittama" method="post">
            <label for="vaittama">Väittämä:</label>
            <input type="text" name="vaittama" size="30" />
            <br><br>           
            <button type="submit">Lisää</button>
        </form>
    </div>
   
<div class="footer">
		<p>&copy; Vaalikone. All rights reserved.</p>
	</div>
</body>
</html>
<% } else {%>
    <p> Not logged in </p>
<% } %>

