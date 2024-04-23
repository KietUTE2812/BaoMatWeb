<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
.main-panel {
	padding: 20px; /* Thêm padding để không bị lộn màu nền vào mép */
	max-height: 100%
}

body {
	font-family: Arial, sans-serif;
}

div {
	margin-bottom: 10px;
}

label {
	display: block;
	margin-bottom: 5px;
}

input {
	width: 100%;
	padding: 5px;
	box-sizing: border-box;
}

button {
	padding: 8px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btnluu {
	margin-top: 20px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar (3 cột) -->
			<div class="col-md-2">
				<jsp:include page="P_sidebar.jsp"></jsp:include>
			</div>

			<!-- Nội dung (9 cột) -->
			<div class="col-md-10">
				<main class="main-panel">
					<div id="details">
						<h2>Thông Tin Tài Khoản</h2>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>
						<c:forEach var="taikhoan" items="${taikhoan}">
							<label for="maTK1">Mã Tài Khoản:</label>
							<input type="text" name="maTK1" id="maTK1"
								value="<c:out value='${taikhoan.maTK}' />" readonly>
							<label for="username1">Tên đăng nhập:</label>
							<input type="text" name="username1" id="username1"
								value="<c:out value='${taikhoan.username}' />" readonly>
							<label for="password1">Mật khẩu:</label>
							<input type="password" name="password1" id="password1"
								value="<c:out value='${taikhoan.password}' />" readonly>
							<label for="role1">Quyền:</label>
							<input type="text" name="role1" id="role1"
								value="<c:out value='${taikhoan.role}' />" readonly>
							<%-- <label for="status1">Trạng thái:</label>
							<input type="text" name="status1" id="status1"
								value="<c:out value='${taikhoan.trangthai}' />" readonly> --%>

							<label for="mapql1">Mã phòng quản lý:</label>
							<input type="text" name="mapql1" id="mapql1"
								value="<c:out value='${taikhoan.maPQl}' />" readonly>
							<label for="nguoidaidien1">Người đại diện:</label>
							<input type="text" name="nguoidaidien1" id="nguoidaidien1"
								value="<c:out value='${taikhoan.nguoiDaiDien}' />" readonly>
							<label for="sdt1">Số điện thoại:</label>
							<input type="text" name="sdt1" id="sdt1"
								value="<c:out value='${taikhoan.getSDT()}' />" readonly>
							<label for="email1">Email:</label>
							<input type="text" name="email1" id="email1"
								value="<c:out value='${taikhoan.getEmail()}' />" readonly>
							<label for="diachi1">Địa chỉ:</label>
							<input type="text" name="diachi1" id="diachi1"
								value="<c:out value='${taikhoan.getDiaChi()}' />" readonly>

							<button class="btnluu" onclick="editDetails()">Chỉnh Sửa</button>
						</c:forEach>
					</div>

					<div id="updateDetails" style="display: none;">
						<h2>Chỉnh Sửa Thông Tin Tài Khoản</h2>
						<c:forEach var="taikhoan" items="${taikhoan}">
							<label for="maTK">Mã Tài Khoản:</label>
							<input type="text" name="maTK" id="maTK"
								value="<c:out value='${taikhoan.maTK}' />" readonly>
							<label for="username">Tên đăng nhập:</label>
							<input type="text" name="username" id="username"
								value="<c:out value='${taikhoan.username}' />" readonly>
							<label for="password">Mật khẩu:</label>
							<input type="text" name="password" id="password"
								onchange="togglePassword()"
								value="<c:out value='${taikhoan.password}' />" required>
							<label for="role">Quyền:</label>
							<input type="text" name="role" id="role"
								value="<c:out value='${taikhoan.role}' />" readonly>
							<%-- <label for="status">Trạng thái:</label>
							<input type="text" name="status" id="status"
								value="<c:out value='${taikhoan.trangthai}' />" readonly> --%>

							<label for="mapql">Mã phòng quản lý:</label>
							<input type="text" name="mapql" id="mapql"
								value="<c:out value='${taikhoan.maPQl}' />" required readonly>
							<label for="nguoidaidien">Người đại diện:</label>
							<input type="text" name="nguoidaidien" id="nguoidaidien"
								value="<c:out value='${taikhoan.nguoiDaiDien}' />" required>
							<label for="sdt">Số điện thoại:</label>
							<input type="text" name="sdt" id="sdt"
								value="<c:out value='${taikhoan.getSDT()}' />" required>
							<label for="email">Email:</label>
							<input type="text" name="email" id="email"
								value="<c:out value='${taikhoan.getEmail()}' />" required>
							<label for="diachi">Địa chỉ:</label>
							<input type="text" name="diachi" id="diachi"
								value="<c:out value='${taikhoan.getDiaChi()}' />" required>

							<button class="btnluu" onclick="saveUpdatedData()">Lưu
								Thay Đổi</button>
							<button class="btnluu" onclick="huyupdate()">Hủy</button>
						</c:forEach>
					</div>
				</main>
			</div>
		</div>
	</div>
	<script>
		function huyupdate() {
			document.getElementById("updateDetails").style.display = "none";
			document.getElementById("details").style.display = "block";
		}
		function editDetails() {
			document.getElementById("updateDetails").style.display = "block";
			document.getElementById("details").style.display = "none";
			
		}

		function saveUpdatedData() {
			var matkhau = document.getElementById("password").value;
			var nguoidaidien = document.getElementById("nguoidaidien").value;
			var sdt = document.getElementById("sdt").value;
			var email = document.getElementById("email").value;
			var diachi = document.getElementById("diachi").value;
			var mapql = document.getElementById("mapql").value;
			var matk = document.getElementById("maTK").value;

			
			var data = {
				nguoidaidien : nguoidaidien,
				matkhau : matkhau,
				sdt : sdt,
				email : email,
				diachi : diachi,
				mapql : mapql,
				matk : matk,
			}
			$.ajax({
				type : "GET",
				url : "updatetkp",
				data : data,
				success : function(response) {
					
					window.location.href = "/web_ck/p_taikhoan";

				},
				error : function(error) {
					console.log(error);
				}
			});

			
		}
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
