<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>  
<%@ page import="com.fdm.highschool.entities.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clase</title>
</head>
<body>

	<%
		List<Clasa> clase = (List<Clasa>)request.getAttribute("clase");
	%>

	<h1>Clase</h1>
	<table>
		<tr>
			<th>
				Nume clasa
			</th>
			<th>
				Numar elevi
			</th>
			<th>
				Actions
			</th>			
		</tr>	
		<%
			for(Clasa clasa : clase) { %>
				<tr>
					<td><%= clasa.getNume()%></td>				
					<td><%= clasa.getNumarElevi()%></td>						
					<td>Edit Delete</td>				
				</tr>
			<%}%>
	
	</table>

</body>
</html>