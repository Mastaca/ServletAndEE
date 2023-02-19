<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The login page</title>
</head>
<body>

	<form action="loginServlet" method="post">
	<h1>Login page</h1>
	Enter username: <input type="text" name="userName"><br>
	Enter password: <input type="password" name="userPassword"><br>
	<input type="submit" value="Login"><br>	
	</form>

</body>
</html>