
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="Admin_Model.AD_GiangVien"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem Giảng Viên</title>
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
.card {
    border: 1px solid #17a2b8;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-top: 20px; /* Thêm khoảng trống trên cùng */
}

form {
    max-width: 600px;
    margin: auto;
}

.form-group {
    margin-bottom: 20px;
}

body {
    padding-top: 20px;
    background-color: #f8f9fa; /* Màu nền phổ biến trong Bootstrap */
}

.main-panel {
    margin: 20px;
}

.card-body {
    padding: 20px; /* Thêm padding để tăng sự thoải mái */
}

label {
    font-weight: bold; /* Tăng độ đậm cho nhãn */
}

.btn-success {
    background-color: #28a745; /* Màu xanh lá cây cho nút "Chỉnh Sửa" */
    color: #fff; /* Màu chữ trắng */
}
.imagee{
margin-top:30px;
}

</style>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar (3 cột) -->
			<div class="col-md-2">
				<jsp:include page="AD_sidebar.jsp"></jsp:include>
			</div>

			<!-- Nội dung (9 cột) -->
			<div class="col-md-10">
				<main class="main-panel">

					<div class="row">
						<div class="col-md-5">


							<img class="imagee" src="${tkadmin.imagead}" alt="ERROR"
								style="width: 400px; height: 500px">
						</div>
						<div class="container col-md-7">
							<div class="card">
								<div class="card-body">
									<form action="<%=request.getContextPath()%>/AD/show_updateadmintaikhoan" method="post">
										<!-- Assuming "updategv" is the correct action -->
										<caption>
											<h2>Thông Tin Tài Khoản</h2>
										</caption>

										<fieldset class="form-group">
											<label>Mã Admin</label> <input type="text"
												value="<c:out value='${tkadmin.maAdmin}' />"
												class="form-control" name="MaAdmin" required="required"
												readonly>
										</fieldset>

										<fieldset class="form-group">
											<label>Họ Tên</label> <input type="text"
												value="<c:out value='${tkadmin.hoTen}' />"
												class="form-control" name="HoTen" readonly>
										</fieldset>

										<fieldset class="form-group">
											<label>Email</label> <input type="text"
												value="<c:out value='${tkadmin.email}' />"
												class="form-control" name="Email" readonly>
										</fieldset>




										<%-- <fieldset class="form-group">
											<label>Ngày Sinh</label> <input type="text"
												value="<c:out value='${tkadmin.ngaySinh}' />"
												class="form-control" name="NgaySinh" readonly>
										</fieldset> --%>
										
										<fieldset class="form-group">
											<label>Ngày Sinh</label>
											<fmt:parseDate var="localDate" value="${tkadmin.ngaySinh}"
												pattern="yyyy-MM-dd" />
											<fmt:formatDate value="${localDate}" pattern="dd/MM/yyyy"
												var="formattedDate" />
											<input type="text" value="${formattedDate}"
												class="form-control" name="NgaySinh" readonly>
										</fieldset>





										<fieldset class="form-group">
											<label>Mã Tài Khoản</label> <input type="text"
												value="<c:out value='${tkadmin.maTK}' />"
												class="form-control" name="MaTK" readonly>
										</fieldset>

										<fieldset class="form-group">
											<button type="submit" class="btn btn-success">Chỉnh
												Sửa</button>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
				</main>
			</div>
		</div>
	</div>
	</div>



	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>