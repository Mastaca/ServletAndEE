<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="com.fdm.highschool.entities.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elev</title>
</head>
<body>

	<%
	
		Elev e = (Elev) request.getAttribute("elev");
	
	%>

	<form>
	
		<input type="hidden" name="id" value="<%= e.getId() %>"><br>
		nume elev: <%= e.getNume() %><br>
		adresa elev: <%= e.getAdresa() %>
		
	
	</form>

</body>
</html>