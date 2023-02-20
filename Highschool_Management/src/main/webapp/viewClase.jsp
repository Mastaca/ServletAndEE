<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>  
<%@ page import="com.fdm.highschool.entities.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clase</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<%
		List<Clasa> clase = (List<Clasa>)request.getAttribute("clase");
		String isEmpty = request.getParameter("isEmpty");
		if (isEmpty != null) { %>
			<h2>Sunt elevi in clasa, scoateti elevii pentru a putea sterge clasa.</h2>
	<%	}
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
		<%	for(Clasa clasa : clase) { %>
				<tr>
					<td><%= clasa.getNume()%></td>
					<td><%= clasa.getNumarElevi()%></td>
					<td>
						<form action="clase" method="post">
							<input type="hidden" name="id" value = "<%=clasa.getId()%>">
							<button type="submit" name="modify" value="edit">Edit</button>
   							<button type="submit" name="modify" value="delete">Delete</button>
						</form>
					
					</td>
				</tr>
		<%	}%>
	</table>

</body>
</html>