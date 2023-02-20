<%@page import="com.fdm.highschool.service.ElevService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.fdm.highschool.entities.*" %>
<%@ page import="com.fdm.highschool.service.*" %>
<%@ page import="java.util.*" %>
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
		Profesor profesor = ProfesorService.getInstance().findById(id);
		List<Materie> materii = Arrays.asList(Materie.values());
	%>
	
	<h1>Modificare date elev</h1>
	<p>
	
	<form action="profesor" method="post">
	<table>
		<tr>
			<th>
				Nume: 
			</th>
			<td>
				<%=profesor.getNume() %>
			</td>
			<td>
				<input type="text"  name="nume"><br>
			</td>
		</tr>
		<tr>
			<th>
				Materie: 
			</th>
			<td>
				<%=profesor.getMaterie().getDenumire() %>
			</td>
			<td>
				Selectati materia: <br>
				<select name="materie">
					<%	for(Materie m : materii) {%>
							<option value="<%= m.name() %>"><%= m.getDenumire() %></option>
					<%	}%>
				</select>
			</td>
		</tr>
		<tr>
			<th>
				Clasa: 
			</th>
			<td>
				<% 	if (profesor.getClasa() == null) {%>
					Nu este nici o clasa
				<%	} else {%>
					<%= profesor.getClasa().getNume() %>
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