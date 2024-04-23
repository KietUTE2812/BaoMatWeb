<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Admin_Model.AD_Account"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<style>
body, html {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Roboto', sans-serif;
	background-color: #f4f4f4;
}

form {
	max-width: 600px;
	height: 480px;
	margin: auto;
	background: #fff;
	padding: 50px;
	border-radius: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
  
footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 10px;
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>
</head>
<body>
	<jsp:include page="headerlogin.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-7">
				<img
					src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
<%--					src="img/logoUTE.png"--%>
					class="img-fluid" alt="Sample image">
			</div>
			<div class="col-md-5">
				<%
				String errMsg = (String) request.getAttribute("errMsg");
				AD_Account account = (AD_Account) session.getAttribute("user_login");
				%>
				<!-- Check session -->
				<%
				if (account != null) {
				%>
				<%
				response.sendRedirect("error.jsp");
				%>
				<%
				}
				%>
		
				<form action="<%=request.getContextPath()%>/login" method="post">
					<h1 class="mb-4 text-center">Đăng Nhập</h1>
					<div class="mb-3">

<%--						<div class="form-check form-check-inline">--%>
<%--							<input class="form-check-input" type="radio" name="role"--%>
<%--								value="Admin" id="adminRole"> <label--%>
<%--								class="form-check-label" for="adminRole">Admin</label>--%>
<%--						</div>--%>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="role"
								value="GV" id="gvRole"> <label class="form-check-label"
								for="gvRole">Giảng Viên</label>
						</div>
<%--						<div class="form-check form-check-inline">--%>
<%--							<input class="form-check-input" type="radio" name="role"--%>
<%--								value="QL" id="qlRole"> <label class="form-check-label"--%>
<%--								for="qlRole">Phòng QLKH</label>--%>
<%--						</div>--%>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Tài Khoản:</label> <input
							type="text" class="form-control" name="username" id="username">
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mật Khẩu:</label> <input
							type="password" class="form-control" name="password"
							id="password">
					</div>
					<div class="mb-3">
						<a href="AD_forgotPassword.jsp">Quên Mật Khẩu?</a>
					</div>
					<%
					if (errMsg != null) {
					%>
					<p style="color: red; font-weight: bold"><%=errMsg%></p>
					<%
					}
					%>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
