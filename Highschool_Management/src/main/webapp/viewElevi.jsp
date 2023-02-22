<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>  
<%@ page import="com.fdm.highschool.entities.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elevi</title>
<link rel="stylesheet" href="style.css">
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
							<%=elev.getClasa().getNume()%>
						<%}%>
					</td>
					<td>
						<form action="elevi" method="post">
							<input type="hidden" name="id" value = "<%=elev.getId()%>">
							<% request.setAttribute("elev",elev);%>
							<button type="submit" name="modify" value="edit">Edit</button>
   							<button type="submit" name="modify" value="delete">Delete</button>
						</form>
					</td>
				</tr>
			<%}%>
	</table>

</body>
</html>