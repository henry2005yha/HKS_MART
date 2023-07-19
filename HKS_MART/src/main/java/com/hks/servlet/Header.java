package com.hks.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Header
 */
@WebServlet("/Header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/header.jsp").forward(request, response);
		handleRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/header.jsp").forward(request, response);
		handleRequest(request, response);
	}

	 private void handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String requestMethod = request.getMethod();

	        if ("GET".equalsIgnoreCase(requestMethod)) {
	            // Process GET request
	        } else if ("POST".equalsIgnoreCase(requestMethod)) {
	            // Process POST request
	        }
	    }

}
