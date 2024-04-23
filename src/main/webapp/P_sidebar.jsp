<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
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
			<a href="P_TrangChu.jsp" class="sidebar-btn"><i
				class="fa fa-home"></i>Trang chủ</a> <a
				href="<%=request.getContextPath()%>/ThongBao" class="sidebar-btn"><i
				class="fa fa-bell"></i>Thông báo</a> <a
				href="P_QuanLyDT.jsp"
				class="sidebar-btn"><i class="fa fa-tasks"></i>Quản lý đề tài</a> <a
				class="sidebar-btn" onclick="toggleFunctions()"><i
				class="fa fa-check"></i>Xét Duyệt</a>
			<div id="functionButtons" style="display: none;">
				<a class="function-btn" onclick="performFunction1()">Duyệt đề
					tài đăng ký</a> <a class="function-btn" onclick="performFunction2()">Duyệt
					đề tài đề xuất</a> <a class="function-btn" onclick="performFunction3()">Duyệt
					đơn xin gia hạn</a> <a class="function-btn"
					onclick="performFunction4()">Quản lý đợt NCKH</a>
			</div>
			<a href="<%=request.getContextPath()%>/xemdanhsachdetai"
				class="sidebar-btn"><i class="fa fa-check-circle"></i>Nghiệm thu
				đề tài</a> <a href="<%=request.getContextPath()%>/dsmadot" class="sidebar-btn"><i
				class="fa fa-chart-bar"></i>Thống kê</a> <a
				href="<%=request.getContextPath()%>/p_taikhoan" class="sidebar-btn"><i
				class="fa fa-user"></i>Tài khoản</a>
		</aside>
	</div>
	<script>
		function toggleFunctions() {
			var functionButtons = document.getElementById('functionButtons');
			// Hiển thị hoặc ẩn các nút chức năng
			functionButtons.style.display = (functionButtons.style.display === 'none') ? 'block'
					: 'none';
		}

		function performFunction1() {
			window.location.href = "/web_ck_war_exploded/danhsachdetaidk";
			// Thêm logic cho chức năng 1
		}

		function performFunction2() {
			window.location.href = "/web_ck_war_exploded/xemdexuatdetai";
			// Thêm logic cho chức năng 2
		}

		function performFunction3() {
			window.location.href = "/web_ck_war_exploded/danhsachdonxin";
			// Thêm logic cho chức năng 3
		}
		function performFunction4() {
			window.location.href = "/web_ck_war_exploded/danhsachdot";
			// Thêm logic cho chức năng 3
		}
	</script>

</body>
</html>
