<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đề tài nghiên cứu khoa học</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>
body {
	margin: 0;
	font-family: Arial, sans-serif !important;
	display: flex;
	min-height: 100vh;
}

.containerP {
	display: flex;
	height: 100vh;
	margin: 0;
}

.sidebar {
	background-color: #f4f4f4;
	box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	width: 100%;
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
</style>
</head>
<body>
	<div class="containerP">
		<aside class="sidebar">
			<a href="AD_TrangChu.jsp" class="sidebar-btn"><i
				class="fa fa-home"></i>Trang chủ</a> <a href="AD_ThongBao.jsp"
				class="sidebar-btn"><i class="fa fa-bell"></i>Thông báo</a> <a
				href="<%=request.getContextPath()%>/AD/list_account" class="sidebar-btn"><i class="fa fa-tasks"></i>Quản
				lý tài khoản</a> <a href="<%=request.getContextPath()%>/AD/list_giangvien" class="sidebar-btn"><i
				class="fa fa-check-circle"></i>Quản lý giảng viên</a> <a href="<%=request.getContextPath()%>/AD/show_acadmin" class="sidebar-btn"><i
				class="fas fa-user"></i>Trang Cá Nhân</a> 
				
				
		</aside>
	</div>
</body>
</html>
