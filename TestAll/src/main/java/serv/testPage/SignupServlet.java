package serv.testPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignupServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
//		String firstName = "A";
//		String lastName = "B";
//		String userName = "ab";
//		String userPassword = "1234";
		
		ConnectToDataBase.signupUser(firstName, lastName, userName, userPassword);		
		
		response.sendRedirect("login");	
		
	}

}
