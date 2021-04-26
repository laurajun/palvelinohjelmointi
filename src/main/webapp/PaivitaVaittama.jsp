<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Väittämän muokkaus</title>
</head>
<body>
<div class="header">
		<h1>Vaalikone</h1>
	</div>
    
    <div class="action">
        <h2>Muokkaa väittämää</h2>
	 <form action="PaivitaVaittama" method="post">
            <label for="vaittama">ID:</label>
            <input type="text" name="vaittama" size="3" />
            <br><br>           
            <button type="submit">Hae</button>
        </form>
    </div>
   
<div class="footer">
		<p>&copy; Vaalikone. All rights reserved.</p>
	</div>
</body>
</html>