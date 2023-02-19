package serv.testPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/signupServlet")
public class UsernameFilter extends HttpServlet implements Filter {
       
    public UsernameFilter() {
        super();
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String userName = req.getParameter("userName");
		if (ConnectToDataBase.verifyUsername(userName)) {
			if (userName.length() > 4) {
				chain.doFilter(request, response);
			} else {
//				Action.code = "usernameShort";
//				Action.message = "Username must be at least 5 characters long.";
				resp.sendRedirect("signup?code=usernameShort&message=Username must be at least 5 characters long");
			}
		} else {
			Action.code = "alreadyExists";
			Action.message = "Username already exists. Please type in a new one.";
			resp.sendRedirect("signup");
		}		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
