<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
body {
	
	font-family: Arial, sans-serif;
	display: flex;
}

.container {
	margin: 0;
	display: flex;
	height: 100vh;
	
}

.sidebar {
	width: 15%;
	background-color: #f4f4f4;
	padding: 20px;
	box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.main-panel {
	flex: 1;
	padding: 20px;
	background-color: green;
	margin-left: 20px;
}

.sidebar-btn {
	padding: 10px;
	margin-bottom: 10px;
	text-decoration: none;
	color: #333;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.sidebar-btn:hover {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="container">
		<aside class="sidebar">
			<a href="#" class="sidebar-btn" onclick="loadContent('GV_TrangChu.jsp')">Trang
				chủ</a> <a href="#" class="sidebar-btn"
				onclick="loadContent('GV_ThongBao.jsp')">Thông báo</a> <a href="#"
				class="sidebar-btn" onclick="loadContent('GV_DangKyDT.jsp')">Đăng
				ký đề tài</a> <a href="#" class="sidebar-btn"
				onclick="loadContent('GV_DeTai.jsp')">Đề tài</a> <a href="#"
				class="sidebar-btn" onclick="loadContent('GV_QuanLySV.jsp')">Quản
				lý sinh viên</a> <a href="#" class="sidebar-btn"
				onclick="loadContent('GV_TaiKhoan.jsp')">Tài khoản</a>
		</aside>
		<main class="main-panel">
			<!-- Initial content or content loaded dynamically based on the selected button -->
			<h1>Welcome to Your Dashboard!</h1>
		</main>
	</div>

	<script>
        function loadContent(url) {
            var mainPanel = document.querySelector('.main-panel');
            mainPanel.innerHTML = ''; // Clear previous content

            fetch(url)
                .then(response => response.text())
                .then(data => {
                    mainPanel.innerHTML = data;
                })
                .catch(error => console.error('Error:', error));
        }
    </script>
</body>
</html>