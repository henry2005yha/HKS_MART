package com.hks.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hks.bean.userBean;
import com.hks.util.DB;

/**
 * Servlet Filter implementation class CheckingUser
 */
@WebFilter("/*")
public class CheckingUser extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest) req;

		if (request.getRequestURI().startsWith("/HKS_MART/")) {
			
			// Retrieve the user information from the cookie
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				System.out.println("I am in cookie scope");
				Connection con = null;
				PreparedStatement ps = null;
				ArrayList<userBean> user = new ArrayList<>();
				HttpSession session = request.getSession();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("userList")) {
						int userId = Integer.parseInt(cookie.getValue());

						System.out.println(userId + "in filter");

						try {
							con = DB.createConnection();
							ps = con.prepareStatement("select * from account where user_id=?");
							ps.setInt(1, userId);

							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								userBean u = new userBean(rs.getInt("user_id"), rs.getString("user_name"),
										rs.getString("user_mail"), rs.getString("user_password"),
										rs.getString("user_address"));
								user.add(u);
							}
							session.setAttribute("user_detail", user);
							System.out.println("done session");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}
		}

		chain.doFilter(req, resp);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
