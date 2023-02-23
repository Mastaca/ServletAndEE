<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="com.fdm.highschool.entities.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profesor</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<%
	Profesor p = (Profesor) request.getAttribute("profesor");
	%>
	
	<h1>Informatii profesor</h1>
	
	<table>
	<form>
		<input type="hidden" name="id" value="<%= p.getId() %>"><br>
		<tr>
			<th>
				Nume: 
			</th>			
			<td>
				<%= p.getNume() %>
			</td>
		</tr>
		<tr>
			<th>
				materie: 
			</th>			
			<td>
				<%= p.getMaterie().getDenumire() %>
			</td>
		</tr>
	</form>
	</table>

</body>
</html>