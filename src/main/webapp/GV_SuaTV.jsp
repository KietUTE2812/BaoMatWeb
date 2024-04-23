<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa đề tài</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
.main-panel {
	padding: 20px;
	max-height: 100%;
}

.table-noti {
	margin-bottom: 20px;
	/* Thêm khoảng cách giữa bảng và nút Gửi thông báo */
}

.send-noti {
	display: flex;
	justify-content: flex-end; /* Căn phải */
}

.btn-send {
	display: flex;
	justify-content: flex-end; /* Căn phải */
}

.table-container {
	max-height: 400px; /* Đặt chiều cao tối đa cho phần tbody */
	overflow-y: auto;
}

.fixed-header th {
	position: sticky;
	top: 0;
	background-color: #f5f5f5; /* Màu nền cho header cố định */
}

.table-container td {
	max-width: 200px;
	word-wrap: break-word;
}

.tc img {
	max-width: 1200px;
	max-height: 900px;
	margin-right: 10px;
}
table{
	width : 200%
	
}
a#button {
	text-decoration: none;
	color: white;
	background-color: #007bff;
	border-radius: 5px;
	padding: 5px;
	width: 150px;
	text-align: center;
}

.form {
	width: 100%;
	max-width: 20rem;
	margin: 0 auto;
	position: relative;
	top: 10%;
	left: -20%;
}

.input {
	display: block;
	width: 100%;
	height: 2.5rem;
	margin-bottom: .5rem;
	padding: .5rem 1rem;
	background: #b1e4d7;
	border: none;
	border-radius: 2px;
}

.button {
	transition: border .2s ease-in-out, background .2s ease-in-out, color
		.2s ease-in-out;
	display: block;
	width: calc(100% - 10rem);
	height: 2.5rem;
	margin: 0 5rem;
	background: #5fb3b3;
	border: 1px solid #5fb3b3;
	border-radius: 1.25rem;
	outline: none;
	color: #fff;
	font-size: .7rem;
	text-transform: uppercase;
	letter-spacing: .5px; &: hover { background : transparent;
	border-color: #5fb3b3;
	color: #5fb3b3;
}

}
h3 {
	text-align: center !important;
	color: #5f83b3 !important;
	font-size: 1.5rem !important;
	margin-bottom: 1rem !important;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="row">

			<div class="col-md-2">
				<jsp:include page="/GV_List.jsp"></jsp:include>
			</div>


			<div class="col-md-10">
					<%-- <form class="form" data-form="form-1" method="post"
						action="<%=request.getContextPath()%>/ANhom" >
						<h3>Thêm Nhóm</h3>
						<c:if test="${errAddNhom != null}">
							<p><c:out value="${errAddNhom}" /></p>
						</c:if>
						<table>
							<tr>
								<td>Tên Nhóm:</td>
								<td><input type="text" class="input" id="magv"
									name="magv" readonly value = "<c:out value="${ttgv.getMaGV()}" />"></td>
							</tr>
							<tr>
								<td>Tên Nhóm:</td>
								<td><input type="text" class="input" id="tennhom"
									name="tennhom" required autocomplete="off"></td>
						</table>


						<input type="submit" value="Thêm" class="button">
					</form> --%>
					<form class="form" data-form="form-1" method="post"
						action="<%=request.getContextPath()%>/GV/EditTV">
						<h3>Chỉnh sửa thông tin</h3>
						<table>
							<tr>
								<td>Tên Nhóm:</td>
								<td><select class="form-control groups d-inline-block"
									id="nhom" name="nhom">

										<c:forEach var="nhom" items="${nhomss}">
											<c:choose>
												<c:when test="${nhom.getMaNhom() eq suasv.getMaNhom()}">
													<option value="${nhom.getMaNhom()}" selected>${nhom.getTenNhom()}</option>
												</c:when>
												<c:otherwise>
													<option value="${nhom.getMaNhom()}">${nhom.getTenNhom()}</option>
												</c:otherwise>
											</c:choose>


										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>MSSV:</td>
								<td><input type="text" class="input" id="mssv" name="mssv"
									value="${suasv.getMSSV()}" required autocomplete="off"
									pattern="\d*" readonly title="Chỉ được nhập số nguyên"></td>
							</tr>
							<tr>
								<td>Họ và Tên:</td>
								<td><input type="text" class="input" id="name" name="name"
									value="${suasv.getHoTen()}" required autocomplete="off"></td>
							</tr>
							<tr>
								<td>Ngày sinh:</td>
								<td><input type="date" class="input" id="bd" name="bd"
									value="${suasv.getNgaySinh()}" required autocomplete="off"></td>

							</tr>
							<tr>
								<td>Email:</td>
								<td><input type="email" class="input" id="email"
									value="${suasv.getEmail()}" name="email" required
									autocomplete="off"></td>

							</tr>
							<tr>
								<td>CCCD:</td>
								<td><input type="text" class="input" id="cccd" name="cccd"
									value="${suasv.getCCCD()}" required autocomplete="off"
									minlength="12" pattern="\d*" title="Chỉ được nhập số nguyên"></td>

							</tr>
							<tr>
								<td>SDT:</td>
								<td><input type="text" class="input" id="sdt" name="sdt"
									value="${suasv.getSDT()}" required autocomplete="off"
									minlength="10" pattern="\d*" title="Chỉ được nhập số nguyên"></td>

							</tr>
							<tr>
								<td>Niên Khóa:</td>
								<td><select name="nienkhoa"
									id="nienkhoa" class="input">
										<option value="2019"
											<c:if test="${suasv.getNienKhoa() eq '2019'}">selected</c:if>>2019</option>
										<option value="2020"
											<c:if test="${suasv.getNienKhoa() eq '2020'}">selected</c:if>>2020</option>
										<option value="2021"
											<c:if test="${suasv.getNienKhoa() eq '2021'}">selected</c:if>>2021</option>
										<option value="2022"
											<c:if test="${suasv.getNienKhoa() eq '2022'}">selected</c:if>>2022</option>
										<option value="2023"
											<c:if test="${suasv.getNienKhoa() eq '2023'}">selected</c:if>>2023</option>
								</select></td>

							</tr>
							<tr>
								<td>Địa chỉ:</td>
								<td><input type="text" class="input" id="diachi"
									value="${suasv.getDiaChi()}" name="diachi" required
									autocomplete="off"></td>

							</tr>
							<tr>
								<td>Ngành:</td>
								<td><select name="nganh" id="nganh" class="input">
										<c:forEach var="nganh" items="${nganhs}">

											<c:choose>
												<c:when test="${nganh.getMaNganh() eq suasv.getMaNganh()}">
													<option value="${nganh.getMaNganh()}" selected>${nganh.getTenNganh()}</option>
												</c:when>
												<c:otherwise>
													<option value="${nganh.getMaNganh()}">${nganh.getTenNganh()}</option>
												</c:otherwise>
											</c:choose>

										</c:forEach>

								</select></td>

							</tr>
						</table>


						<input type="submit" value="Sửa" class="button">
					</form>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>