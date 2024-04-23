<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
	text-align: center;
	margin: 0;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.error-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	width: 100%;
	text-align: left;
}

h1 {
	color: #d9534f;
}
</style>
</head>
<body>
	<div class="error-container">
		<h1>Error</h1>
		<%
		// Kiểm tra nếu ngoại lệ tồn tại trước khi gọi getMessage()
		if (request.getAttribute("ERROR_MESSAGE") != null) {
		%>
		<p><%=request.getAttribute("ERROR_MESSAGE")%></p>
		<%
		} else {
		%>
		<p>An error occurred. Please contact the administrator for
			assistance.</p>
		<%
		}
		%>
	</div>
</body>
</html>