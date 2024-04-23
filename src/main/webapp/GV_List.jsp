<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	margin: 0;
	font-family: Arial, sans-serif !important;
	display: flex;
	min-height: 100vh;
	flex: 1;
}

.containerP {
	display: flex;
	height: 100vh;
	margin: 0;
	flex: 1;
}

.sidebar {
	background-color: #f4f4f4;
	box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	width: 100%;
	flex: 1;
}

.sidebar-btn {
	padding: 10px;
	margin-bottom: 10px;
	text-decoration: none !important;
	color: #333;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
	display: flex; /* Sử dụng flexbox để căn giữa theo chiều ngang */
	align-items: center; /* Căn giữa theo chiều dọc */
	width: 100%;
}

.sidebar-btn i {
	margin-right: 10px; /* Khoảng cách giữa biểu tượng và nội dung */
}

.sidebar-btn span {
	margin-left: 10px; /* Khoảng cách giữa nội dung và biểu tượng */
}

.sidebar-btn:hover {
	background-color: #ddd;
}

#functionButtons {
	background-color: #f4f4f4;
	display: flex;
	flex-direction: column;
	width: 100%;
}

.function-btn {
	padding: 10px;
	margin-top: 10px;
	text-decoration: none !important;
	color: #333;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
	display: flex;
	align-items: center;

	/* width: 100%; // Loại bỏ thuộc tính này */
}

.function-btn:hover {
	background-color: #ddd;
}
</style>

</head>
<body>
	
	<div class="containerP">
		<aside class="sidebar">
			<a href="<%=request.getContextPath()%>/GV/main" class="sidebar-btn"><i
				class="fa fa-home"></i>Trang chủ</a> <a
				href="<%=request.getContextPath()%>/GV/ShowAllTB"
				class="sidebar-btn"><i class="fa fa-bell"></i>Thông báo</a> <a
				href="<%=request.getContextPath()%>/GV/showDT"
				class="sidebar-btn"><i class="fa fa-tasks"></i>Đăng ký đề tài</a> 
			
			
			<a href="<%=request.getContextPath()%>/GV/qldt"
				class="sidebar-btn"><i class="fa fa-check-circle"></i>Đề tài của tôi</a> <a href="<%=request.getContextPath()%>/GV/qlsv"
				class="sidebar-btn"><i class="fa fa-chart-bar"></i>Quản lý nhóm</a> <a
				href="<%=request.getContextPath()%>/GV/info" class="sidebar-btn"><i
				class="fa fa-user"></i>Tài khoản</a>
		</aside>
	</div>
</body>
</html>