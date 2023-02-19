<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.fdm.highschool.entities.*" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<Materie> materii = Arrays.asList(Materie.values());	
	%>

	<form action="profesor" method="post">
	
		<input type="text"  name="nume"><br>
		Selectati materia: <br>
		<select name="materie">
			<%			
				for(Materie m : materii) { %>
					<option value="<%= m.name() %>"><%= m.getDenumire() %></option>
				<%}
			%>
		</select>
		<input type="submit" value="Creare profesor">
		
	</form>

</body>
</html>