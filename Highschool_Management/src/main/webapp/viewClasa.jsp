<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.fdm.highschool.entities.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clasa</title>
</head>
<body>

	<%
		Clasa c = (Clasa) request.getAttribute("clasa");	
	%>

	<form>	
		<input type="hidden" name="id" value="<%= c.getId() %>"><br>
		nume clasa: <%= c.getNume() %><br>
		numar elevi: <%= c.getNumarElevi() %>
	</form>

</body>
</html>