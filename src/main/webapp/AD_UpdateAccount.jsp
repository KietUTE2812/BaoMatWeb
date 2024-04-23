
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh Sửa Tài Khoản</title>
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
.image {
	height: 500px;
	width: 400px
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
						<div class="container col-md-7">
							<div class="card">
								<div class="card-body">
									<form action="<%=request.getContextPath()%>/AD/update_taikhoan" method="post">
										<caption>
											<h2>Chỉnh Sửa Thông Tin Giảng Viên</h2>
										</caption>

										<fieldset class="form-group">
											<label>Mã Tài Khoản</label> <input type="text"
												value="<c:out value='${edittaikhoan.maTK}' />"
												class="form-control" name="MaTK" readonly
												required="required">
										</fieldset>

										<fieldset class="form-group">
											<label>Tên Đăng Nhập</label> <input type="text"
												value="<c:out value='${edittaikhoan.username}' />"
												class="form-control" name="username">
										</fieldset>

										<fieldset class="form-group">
											<label>Mật Khẩu</label> <input type="text"
												value="<c:out value='${edittaikhoan.password}' />"
												class="form-control" name="password">
										</fieldset>

										<%-- <fieldset class="form-group">
											<label>Role</label> <input type="text"
												value="<c:out value='${edittaikhoan.role}' />"
												class="form-control" name="role">
										</fieldset>
 --%>
										<div class="form-group">
											<label>Vai Trò</label> <select name="role"
												class="form-select" aria-label="Default select example">
												<option value="Admin"
													<c:if test="${edittaikhoan.role == 'Admin'}">selected</c:if>>Admin</option>
												<option value="GV"
													<c:if test="${edittaikhoan.role == 'GV'}">selected</c:if>>Giảng
													viên</option>
												<option value="QL"
													<c:if test="${edittaikhoan.role == 'QL'}">selected</c:if>>Quản
													lý</option>
											</select>
										</div>

										<fieldset class="form-group">
											<button type="submit" class="btn btn-success">Save</button>
										</fieldset>

									</form>
								</div>
							</div>
						</div>
				</main>
			</div>
		</div>
	</div>




	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>