package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class NameFilter
 */
@WebFilter("/addAlien")
public class NameFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NameFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
PrintWriter out = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest) request;
		String aName = req.getParameter("aName");
		
		if (aName.length() > 2) {
			chain.doFilter(request, response);
		} else if (aName.length() == 0) {
			out.write("Name has to be at least 3 characters long");
		} else {
			out.write("Name is too short");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
