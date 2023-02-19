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
public class PasswordFilter extends HttpServlet implements Filter {
       
    public PasswordFilter() {
        super();
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String password = req.getParameter("userPassword");
		if (password.length() > 4) {
			chain.doFilter(request, response);
		} else {
			Action.code = "passwordShort";
			Action.message = "Password must be at least 5 characters long, must contain a number, an uppercase character, a symbol and your credit card number.";
			resp.sendRedirect("signup");
		}
			
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
