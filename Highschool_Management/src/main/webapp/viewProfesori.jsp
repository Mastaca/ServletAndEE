<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="com.fdm.highschool.entities.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profesori</title>
</head>
<body>

	<%
		List<Profesor> profesori = (List<Profesor>)request.getAttribute("profesori");
	%>
	
	<h1>Lista profesori</h1>
	<table>
		<tr>
			<th>
				Nume profesor
			</th>
			<th>
				Materie
			</th>
			<th>
				Actions
			</th>
		</tr>
		
		<%	for(Profesor p : profesori) { %>
				<tr>
					<td><%= p.getNume()%></td>
					<td><%= p.getMaterie()%></td>
					<td>Edit Delete</td>
				</tr>
		<%	}%>
	</table>

</body>
</html>