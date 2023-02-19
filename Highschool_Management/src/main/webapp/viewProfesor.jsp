<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="com.fdm.highschool.entities.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profesor</title>
</head>
<body>

	<%
	
	Profesor p = (Profesor) request.getAttribute("profesor");
	
	%>

	<form>
	
		<input type="hidden" name="id" value="<%= p.getId() %>"><br>
		nume profesor: <%= p.getNume() %><br>
		materie profesor: <%= p.getMaterie().getDenumire() %>
		
	
	</form>

</body>
</html>