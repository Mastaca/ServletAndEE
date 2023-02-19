<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The signup page</title>
</head>
<body>

	<%
		String invalidSignup = null;
		String invalidMessage = null;
		try{
			invalidSignup = request.getParameter("code");
			invalidMessage = request.getParameter("message");
			
			if (invalidMessage != null) {
				out.print(invalidMessage);	
			}
			
			
		} catch (Exception e) {		
		}
		
		/* try{
			invalidSignup = serv.testPage.Action.code;
			if (invalidSignup.equals("alreadyExists")) {
				out.write(serv.testPage.Action.message);
			} else if (invalidSignup.equals("usernameShort")) {
				out.write(serv.testPage.Action.message);
			} else if (invalidSignup.equals("passwordShort")) {
				out.write(serv.testPage.Action.message);
			}
			serv.testPage.Action.code = null;
			serv.testPage.Action.message = null;
		} catch (Exception e) {		
		} */
	%>
	<form action="signupServlet" method="post">
	<h1>Signup page</h1>
	Enter first name: <input type="text" name="firstName"><br>
	<p>
	Enter last name: <input type="text" name="lastName"><br>
	<p>
	Enter username: <input type="text" name="userName"><br>
	<p>
	Enter password: <input type="password" name="userPassword"><br>
	<p>
	<input type="submit" value="Singup"><br>	
	</form>

</body>
</html>