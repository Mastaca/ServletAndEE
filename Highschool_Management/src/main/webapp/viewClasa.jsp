<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.fdm.highschool.entities.*" %>
<%@ page import="com.fdm.highschool.service.*" %>
<%@ page import="java.util.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clasa</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%
		Clasa c = (Clasa) request.getAttribute("clasa");
		List<Profesor> profesori = ClasaService.getInstance().findProfesors(c.getId());
	%>
	
	<h1>Informatii clasa</h1>
	
	<table>
	<form>
		<input type="hidden" name="id" value="<%= c.getId() %>"><br>
		<tr>
			<th>
				Nume clasa: 
			</th>			
			<td>
				<%= c.getNume() %>
			</td>
		</tr>
		<tr>
			<th>
				Numar elevi: 
			</th>			
			<td>
				<%= c.getNumarElevi() %>
			</td>
		</tr>
		<tr>
			<th>
				Lista profesori: 
			</th>			
			<td>
				<%	if (profesori != null && !profesori.isEmpty()) {
					for (Profesor p : profesori) { %>
						<%=p.getNume()%> - <%=p.getMaterie().getDenumire()%> 
						<br>
						<%}} else {out.write("Nu sunt professori");}%>
			</td>
		</tr>
	</form>
	</table>

</body>
</html>