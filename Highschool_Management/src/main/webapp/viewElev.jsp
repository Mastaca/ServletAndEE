<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.fdm.highschool.entities.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date elev</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<%
		Elev e = (Elev) request.getAttribute("elev");
	%>
	<h1>Informatii elev</h1>
	<table>
	<form>
		<input type="hidden" name="id" value="<%= e.getId() %>"><br>
		<tr>
			<th>
				Nume: 
			</th>			
			<td>
				<%= e.getNume() %>
			</td>
		</tr>
		<tr>
			<th>
				Adresa: 
			</th>			
			<td>
				<%= e.getAdresa() %>
			</td>
		</tr>
		
		<tr>
			<th>
				Clasa: 
			</th>			
			<td>
				<%	if (e.getClasa() != null) {%>
						<%=e.getClasa().getNume()%>	
						<%	} else {%>
						Nu este in clasa.
				<%	}%>
			</td>
		</tr>
		</table>
		
		
		
	</form>

</body>
</html>