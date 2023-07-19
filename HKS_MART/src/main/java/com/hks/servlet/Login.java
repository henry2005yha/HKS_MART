package com.hks.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hks.bean.userBean;
import com.hks.util.DB;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String login = null;
		ArrayList<userBean> user = new ArrayList<>();
		HttpSession session = request.getSession();
		
		
		
		try {
			
			String Mail = request.getParameter("txtMail");
			String Pwd = request.getParameter("txtPwd");
			

			con = DB.createConnection();
			ps = con.prepareStatement("select * from account where user_mail=? and user_password=?");

			ps.setString(1, Mail);
			ps.setString(2, Pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String userId = Integer.toString(rs.getInt("user_id"));
				
				userBean u = new userBean(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_mail"), rs.getString("user_password"), rs.getString("user_address"));
			    user.add(u);

			    Cookie cookie = new Cookie("userList", userId);
			    cookie.setMaxAge(86400);// 24 hour 
			    response.addCookie(cookie);
			    
			    System.out.println("in login servlet"+userId);
			    
			    response.sendRedirect("Header");
			    
			} else {
				login = "failed";
				session.setAttribute("login", login);
				response.sendRedirect("Account");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
