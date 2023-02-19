<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>  
<%@ page import="com.fdm.highschool.entities.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elevi</title>
</head>
<body>

	<%
		List<Elev> elevi = (List<Elev>)request.getAttribute("elevi");
	%>

	<h1>Lista elevi</h1>
	<table>
		<tr>
			<th>
				Nume elev
			</th>
			<th>
				Adresa elev
			</th>
			<th>
				Clasa elev
			</th>
			<th>
				Actions
			</th>			
		</tr>	
		<%
			for(Elev elev : elevi) { %>
				<tr>
					<td><%= elev.getNume()%></td>				
					<td><%= elev.getAdresa()%></td>				
					<td><% if (elev.getClasa().getId() == 0){ %>
							Nu este nici o clasa
						<%} else {%>
							<%=elev.getClasa().getId()%>
						<%}%>
					</td>
					<td>Edit Delete</td>				
				</tr>
			<%}%>
	
	</table>

</body>
</html>