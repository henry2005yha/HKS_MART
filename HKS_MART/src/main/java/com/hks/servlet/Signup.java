package com.hks.servlet;

import java.io.IOException;
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

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		String signUp = null;
		ArrayList<userBean> user = new ArrayList<>();
		HttpSession session = request.getSession();

		try {
			String Name = request.getParameter("txtName");
			String Mail = request.getParameter("txtMail");
			String Pwd = request.getParameter("txtPwd");
			String Loc = request.getParameter("txtLoc");

			// connect to Database
			con = DB.createConnection();

			// Check if the email already exists in the database
			PreparedStatement checkEmailStatement = con
					.prepareStatement("SELECT COUNT(*) FROM account WHERE user_mail = ?");
			checkEmailStatement.setString(1, Mail);
			ResultSet emailCheckResult = checkEmailStatement.executeQuery();
			emailCheckResult.next();
			int emailCount = emailCheckResult.getInt(1);

			if (emailCount > 0) {
				// Email already exists, handle the error or display a message to the user
				
				signUp = "failed";
				session.setAttribute("signUp", signUp);
				response.sendRedirect("Account");
				
			} else {

				ps = con.prepareStatement(
						"INSERT INTO `hks`.`account` (`user_name`, `user_mail`, `user_password`, `user_address`) VALUES (?,?,?,?)");

				ps.setString(1, Name);
				ps.setString(2, Mail);
				ps.setString(3, Pwd);
				ps.setString(4, Loc);
				int rs1 = ps.executeUpdate();
				if (rs1 > 0) {

					ps1 = con.prepareStatement("select * from account where user_mail=? and user_password=?");
					ps1.setString(1, Mail);
					ps1.setString(2, Pwd);
					ResultSet rs = ps1.executeQuery();
					if (rs.next()) {
						System.out.println(rs.getInt("user_id") + rs.getString("user_name") + rs.getString("user_mail")
								+ rs.getString("user_password") + rs.getString("user_address"));

						String userId = Integer.toString(rs.getInt("user_id"));

						Cookie cookie = new Cookie("userList", userId);
						cookie.setMaxAge(86400);// 24 hour
						response.addCookie(cookie);

						System.out.println("in signup servlet" + userId);

						response.sendRedirect("Header");
					}

				} else {
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
