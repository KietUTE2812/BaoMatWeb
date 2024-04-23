<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lí Tài Khoản</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	integrity="sha384-eolR+Fss5BLiKKpQteBvps/ihyBBrJzo6OpBkf9eV5PmI2sXf+JvBRdf1zFRP0W5"
	crossorigin="anonymous">
<style>
.modal-content {
    background-color: #f8f9fa; 
    border: 1px solid #ced4da; 
    border-radius: 5px; /* Góc bo tròn */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
}

.modal-header {
    background-color: #007bff; 
    color: #fff; /
}

.modal-footer {
    background-color: #f8f9fa; 
}
.form-group {
    margin-bottom: 15px; 
}

.form-control {
    width: 100%; 
}
.modal-footer input[type="button"],
.modal-footer input[type="submit"] {
    width: 100px; 
    margin-right: 10px;
}
.form-select {
    background-color: #fff; 
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



					<!-- Initial content or content loaded dynamically based on the selected button -->
					<div class="row">
						<div class="container">
							<h3 class="text-center">Quản Lí Tài Khoản</h3>
							<hr>
							<div class="container text-left">
								<!-- Thay đổi từ data-toggle và data-target thành data-bs-toggle và data-bs-target -->
								<a href="#" class="btn btn-success" data-bs-toggle="modal"
									data-bs-target="#addAccountModal">Thêm Tài Khoản</a>
							</div>
							<br>
							<table class="table table-bordered">
								<thead>
									<tr>

										<th>Tên Đăng Nhập</th>
										<th>Mật Khẩu</th>
										<th>Vai Trò</th>
										<th>Mã Tài Khoản</th>
										<th>Hành Động</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach var="account" items="${listtk}">
										<tr>

											<td><c:out value="${account.username}" /></td>
											<td><c:out value="${account.password}" /></td>
											<td><c:out value="${account.role}" /></td>
											<td><c:out value="${account.maTK}" /></td>
											<td>
											
												<a
												
												href="<%=request.getContextPath()%>/AD/show_updatetaikhoan?matkupdate=<c:out value='${account.maTK}' />"><i class="fas fa-edit"></i></a>
												<a
												
												href="<%=request.getContextPath()%>/AD/delete_account?mtkstatus=<c:out value='${account.maTK}' />"><i class="fas fa-trash"></i></a>
											</td>
										</tr>
									</c:forEach>



								</tbody>
							</table>
						</div>
					</div>

					<div id="addAccountModal" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="<%=request.getContextPath()%>/AD/new_account"
									method="post">
									<div class="modal-header">
										<h4 class="modal-title">Thêm Tài Khoản Mới</h4>
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
												<label>Mã Tài Khoản</label> <input name="MaTK" type="text"
													class="form-control" required>
											</div>
										<div class="form-group">
											<label>Tên Đăng Nhập</label> <input name="username" type="text"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>Password</label> <input name="password" type="text"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>Vai Trò</label> <select name="role" class="form-select"
												aria-label="Default select example">
												<option value="Admin" selected>Admin</option>
												<option value="GV">GV</option>
												<option value="QL">QL</option>
											</select>

										</div>
										

									</div>
									<div class="modal-footer">
										<input type="button" class="btn btn-default"
											data-dismiss="modal" value="Cancel"> <input
											type="submit" class="btn btn-success" value="Add">
									</div>
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