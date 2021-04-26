<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
     
        
        <table class="tabledb">
            <caption>
                <h3>Muokkaa väittämää</h3>
            </caption>            
            <input type="hidden" name="id" value="<c:out value='${request.getParameter("id")}' />" />
                        
            <tr>
                <th>ID: </th>
                <td>
                    <input type="text" name="id" size="3"
                            value="<c:out value='${request.getParameter("id")}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Väittämä: </th>
                <td>
                    <input type="text" name="vaittama" size="300"
                            value="<c:out value='${vaittamat.vaittama}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Tallenna" />
                </td>
            </tr>
          
        </table>
        
    </div>

<div class="footer">
		<p>&copy; Vaalikone. All rights reserved.</p>
	</div>
</body>
</html>