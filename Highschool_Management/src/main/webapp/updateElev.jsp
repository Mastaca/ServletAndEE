<%@page import="com.fdm.highschool.service.ElevService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.fdm.highschool.entities.*" %>
<%@ page import="com.fdm.highschool.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificare date elev</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%	
		if (request.getParameter("id") != null){
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Elev elev = ElevService.getInstance().findById(id);
		/* Elev elev = request.getParameter("elev") */
	%>
	
	<h1>Modificare date elev</h1>
	<p>
	
	<form action="elev" method="post">
	<table>
		<tr>
			<th>
				Nume: 
			</th>
			<td>
				<%=elev.getNume() %>
			</td>
			<td>
				<input type="text"  name="nume"><br>
			</td>
		</tr>
		<tr>
			<th>
				Adresa: 
			</th>
			<td>
				<%=elev.getAdresa() %>
			</td>
			<td>
				<input type="text"  name="adresa"><br>
			</td>
		</tr>
		<tr>
			<th>
				Clasa: 
			</th>
			<td>
				<% 	if (elev.getClasa() == null) {%>
					Nu este nici o clasa
				<%	} else {%>
					<%= elev.getClasa().getNume() %>
				<%	}%>
			</td>
			<td>
				<input type="text"  name="clasa"><br>
			</td>
		</tr>
		<tr>
			<td>
				<input type="hidden" name="id" value = "<%=id%>">
				<input type="submit" value="Modificare">
			</td>
		</tr>
	</table>	
	</form>
	
	
	<% } else { %> ID not found <% } %>
</body>
</html>