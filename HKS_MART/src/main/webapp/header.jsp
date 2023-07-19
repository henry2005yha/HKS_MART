<%@page import="java.util.List"%>
<%@page import="com.hks.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="welcome2.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>
	<!-- Navbar syh start -->
	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
		<!-- Container wrapper -->
		<div class="container">
			<!-- Toggle button -->
			<button class="navbar-toggler" type="button"
				data-mdb-toggle="collapse"
				data-mdb-target="#navbarSupportedContent1"
				aria-controls="navbarSupportedContent1" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>




			<!-- Collapsible wrapper -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent1">
				<!-- Navbar -->
				<a class="navbar-brand mt-2 mt-sm-0" href=""> <img
					src="https://rb.gy/m4wah" height="20" alt="MDB Logo" loading="lazy" />
				</a>
				<!-- Left links -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item active"><a class="nav-link "
						href="testpage.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="cartpage.html">About
							HKS</a></li>
				</ul>
				<!-- Left links -->
			</div>

			<!-- Right elements -->
			<div class="d-flex align-items-center">


				<!-- =========== check the user =============== -->
				<%
				Object userObj = session.getAttribute("user_detail");
				%>
				<%
				if (userObj != null) {
				%>

				<%
				List<userBean> userDetail = (List<userBean>) userObj;
				%>
				<%
				for (userBean user_detail : userDetail) {
				%>
				<a class="nav-link me-3">Welcome, <%=user_detail.getUser_name()%>
				</a> <a class="nav-link me-3" href="Logout">log out </a>
				<%
				}
				} else {
				%>




				<a class="nav-link me-3" href="Account"> Log In </a> <a
					class="nav-link me-3" href="Account"> Sign Up </a>


				<%
				}
				%>


				<!-- Icon -->
				<a class="nav-link me-3" href="cartpage.html"> <i
					class="fas fa-shopping-cart"></i> <span
					class="badge rounded-pill badge-notification bg-danger">1</span>

				</a> <a class="nav-link me-3" href="https://www.facebook.com/login.php/">
					<i class="fab fa-facebook-f"></i>
				</a> <a class="nav-link me-3" href="https://twitter.com/i/flow/login">
					<i class="fab fa-twitter"></i>
				</a>

			</div>
			<!-- Right elements -->

		</div>
		<!-- Container wrapper -->
	</nav>
	<!-- Navbar syh end -->
</body>
</html>