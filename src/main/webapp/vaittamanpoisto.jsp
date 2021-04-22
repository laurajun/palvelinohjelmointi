<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone väittämän poisto</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Poista väittämä</h1>
        <form action="PoistaVaittama" method="post">
            <label for="id">Väittämän nro:</label>
            <input type="text" name="id" size="3" />
            <br><br>           
            <button type="submit">Poista</button>
        </form>
    </div>
</body>
</html>