<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biên bản nghiệm thu</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<style>
.main-panel {
	padding: 20px; /* Thêm padding để không bị lộn màu nền vào mép */
	max-height: 100%
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
					<div class="container-nghiemthu">
						<h2 class="my-4">Biên Bản Nghiệm Thu</h2>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>
						<table class="table table-bordered table-striped">
							<thead class="fixed-header">
								<tr>
									<th scope="col">Mã Biên Bản</th>
									<th scope="col">Điểm</th>
									<th scope="col">Đánh Giá</th>
									<th scope="col">Minh Chứng</th>
									<th scope="col">Ngày Nghiệm Thu</th>
									<th scope="col">Mã Đề Tài</th>
									<th scope="col">Mã PQL</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dt" items="${bienbannghiemthu}">

									<tr>
										<td><c:out value="${dt.maBienBan}" /></td>
										<td><c:out value="${dt.diem}" /></td>
										<td><c:out value="${dt.danhGia}" /></td>
										<td><c:out value="${dt.minhChung}" /></td>
										<%-- <td><c:out value="${dt.ngayNghiemThu}" /></td> --%>
										<td><fmt:parseDate var="localDate"
												value="${dt.ngayNghiemThu}" pattern="yyyy-MM-dd" /> <fmt:formatDate
												value="${localDate}" pattern="dd/MM/yyyy"
												var="formattedDate" /> ${formattedDate}</td>

										<td><c:out value="${dt.maDeTai}" /></td>
										<td><c:out value="${dt.maPQL}" /></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<div class="quaylai-container ">
						<button type="button" class="btn btn-success"
							onclick="bienbannghiemthu()">Quay Lại</button>
					</div>
				</main>
			</div>
		</div>
	</div>
	<script>
		function bienbannghiemthu() {
			// Chuyển hướng trang sử dụng JavaScript
			window.location.href = '/web_ck/xemdanhsachdetai';
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
