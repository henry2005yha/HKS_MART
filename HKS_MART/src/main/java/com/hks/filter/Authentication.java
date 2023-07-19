package com.hks.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter("/XXXXXXXXXXXXXXXXXXXX")
public class Authentication extends HttpFilter implements Filter {
private static final long serialVersionUID = 1L;


	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest)request ;
		if (req.getRequestURI().startsWith("/HKS/buy")) {
			HttpSession session = req.getSession();
			if (session.getAttribute("user") == null) {
				req.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
