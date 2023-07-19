<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hks.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Index page</p>
	<div align=center>
		<h1>User Login</h1>
	</div>

	<!-- Log in  -->

	<form action=Login method=post>
		<table>
			<%
			String login = (String) session.getAttribute("login");
			if (login == null) {
				login = "nth";
			}
			%>
			<tr>
				<td>Enter Email:</td>
				<td><input type=email name=txtMail
					placeholder="Enter your name"></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type=password name=txtPwd
					placeholder="Enter your name"></td>
			</tr>
			<%
			if (login.equals("failed")) {
			%>

			<tr>
				<td colspan="2" style="color: red;">incorrect Username or
					password</td>
			</tr>

			<%
			}
			%>


			<tr>
				<td><input type=submit value=Login onclick=check()></td>
				<td><input type=reset value=Cancel></td>
			</tr>

		</table>
	</form>
	<br>
	<br>
	<br>
	<!-- sign up -->

	<form action=Signup>
		<table>
			<%
			String signUp = (String) session.getAttribute("signUp");
			if (signUp == null) {
				signUp = "nth";
			}
			%>
			<tr>
				<td>Enter UserName:</td>
				<td><input type=text name=txtName placeholder="Enter your name"></td>
			</tr>
			<tr>
				<td>Enter Email:</td>
				<td><input type=email name=txtMail
					placeholder="Enter your name"></td>
			</tr>
			<%
			if (signUp.equals("failed")) {
			%>

			<tr>
				<td colspan="2" style="color: red;">This Mail is Already Exist</td>
			</tr>

			<%
			}
			%>
			<tr>
				<td>Enter Password:</td>
				<td><input type=password name=txtPwd
					placeholder="Enter your name"></td>
			</tr>
			<tr>
				<td>Enter Location:</td>
				<td><input type=text name=txtLoc
					placeholder="Enter your location"></td>
			</tr>
			<tr>
				<td><input type=submit value=Login></td>
				<td><input type=reset value=Cancel></td>
			</tr>

		</table>
	</form>




</body>
</html>