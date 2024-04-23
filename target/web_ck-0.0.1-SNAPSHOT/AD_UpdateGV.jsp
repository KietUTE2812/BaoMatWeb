<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh Sửa Thông Tin Giảng Viên</title>
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
	max-width: 100%;
	height: auto;
	border-radius: 10px;
	/* Điều chỉnh giá trị để làm tròn góc theo ý bạn */
}

.card {
	border: 1px solid #17a2b8; /* Màu xanh của Bootstrap */
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

form {
	max-width: 600px; /* Điều chỉnh theo kích thước bạn muốn */
	margin: auto;
}

.form-group {
	margin-bottom: 20px;
}

body {
	padding-top: 20px;
}

.main-panel {
	margin: 20px;
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
							<img class="img-fluid image" src="${forgvupdate.image}"
								class="img-fluid" alt="Sample image" name="Image">
						</div>
						<div class="container col-md-7">
							<div class="card">
								<div class="card-body">
									<form action="<%=request.getContextPath()%>/AD/update_giangvien" method="post"
										enctype="multipart/form-data">
										<caption>
											<h2>Chỉnh Sửa Thông Tin Giảng Viên</h2>
										</caption>

										<fieldset class="form-group">
											<label>Mã Giảng Viên</label> <input type="text"
												value="<c:out value='${forgvupdate.maGV}' />"
												class="form-control" name="MaGV" readonly
												required="required">
										</fieldset>

										<fieldset class="form-group">
											<label>Họ Tên</label> <input type="text"
												value="<c:out value='${forgvupdate.hoTen}' />"
												class="form-control" name="HoTen">
										</fieldset>

										<fieldset class="form-group">
											<label>Email</label> <input type="text"
												value="<c:out value='${forgvupdate.email}' />"
												class="form-control" name="Email">
										</fieldset>

										<fieldset class="form-group">
											<label>Trình Độ</label> <input type="text"
												value="<c:out value='${forgvupdate.trinhDo}' />"
												class="form-control" name="TrinhDo">
										</fieldset>

										<fieldset class="form-group">
											<label>Mã Khoa</label> <input type="text"
												value="<c:out value='${forgvupdate.maKhoa}' />"
												class="form-control" name="MaKhoa">
										</fieldset>

										<fieldset class="form-group">
											<label>Mã Tài Khoản</label> <input type="text"
												value="<c:out value='${forgvupdate.maTK}' />"
												class="form-control" name="MaTK" readonly>
										</fieldset>

										<%--     <fieldset class="form-group">
                        <label>Giới Tính</label>
                        <input type="text" value="<c:out value='${forgvupdate.gioiTinh}' />" class="form-control" name="GioiTinh">
                    </fieldset> --%>

										<div class="form-group">
											<label>Giới Tính</label> <select name="GioiTinh"
												class="form-select" aria-label="Default select example">
												<option value="Nam"
													<c:if test="${forgvupdate.gioiTinh == 'Nam'}">selected</c:if>>Nam</option>
												<option value="Nu"
													<c:if test="${forgvupdate.gioiTinh == 'Nu'}">selected</c:if>>Nữ</option>
											</select>
										</div>
										 <fieldset class="form-group">
											<label>Image</label> <input type="text"
												value="<c:out value='${forgvupdate.image}' />"
												class="form-control" name="Image" >
										</fieldset> 



										<!-- <fieldset class="form-group">
											Hiển thị nút chọn ảnh
											<label>Chọn Ảnh</label> <input type="file"
												class="form-control" name="fileInput" >
										</fieldset> -->

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
	</div>



	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>