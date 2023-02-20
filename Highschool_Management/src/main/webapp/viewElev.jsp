<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.fdm.highschool.entities.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date elev</title>
</head>
<body>
	
	<%
		Elev e = (Elev) request.getAttribute("elev");
	%>
	<h1>Date elev</h1>
	<form>
		<input type="hidden" name="id" value="<%= e.getId() %>"><br>
		Nume: <%= e.getNume() %><br>
		Adresa: <%= e.getAdresa() %><br>
		Clasa: <%
			if (e.getClasa() != null) {%>
		<%=e.getClasa().getNume()%>	
		<%	} else {%>
		Nu este in clasa.
		<%	}%>
		
	</form>

</body>
</html>