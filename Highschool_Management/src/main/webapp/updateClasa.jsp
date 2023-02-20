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
		String idString = request.getParameter("id");
		if (idString != null){
			int id = Integer.parseInt(idString);
			Clasa clasa = ClasaService.getInstance().findById(id);
	%>
	
	<h1>Modificare date clasa</h1>
	<p>
	
	<form action="elev" method="post">
	<table>
		<tr>
			<th>
				Nume: 
			</th>
			<td>
				<%=clasa.getNume() %>
			</td>
			<td>
				<input type="text"  name="nume"><br>
			</td>
		</tr>
		<tr>
			<th>
				Numar elevi: 
			</th>
			<td>
				<%=clasa.getNumarElevi() %>
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
	
	
	<% } else { %> class ID not found <% } %>
</body>
</html>