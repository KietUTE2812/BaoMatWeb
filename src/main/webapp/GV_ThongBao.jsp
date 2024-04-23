<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông báo</title>
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

				<main class="main-panel">
						<div class="table-noti">
							<h2>Danh sách thông báo</h2>
							<div class="table-container">
								<table class="table table-bordered table-striped">
									<thead class="fixed-header">
										<tr>
											<th scope="col">Tiêu đề</th>
											<th scope="col">Người gửi</th>
											<th scope="col">Ngày gửi</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="thongBao" items="${tbs}">
											<tr onclick="showDetail(this)">
												<td><c:out value="${thongBao.getTieuDe()}" /></td>
												<td><c:out value="${thongBao.getNguoiGui()}" /></td>
												<td><fmt:parseDate var="localDate"
														value="${thongBao.getNgayGui()}" pattern="yyyy-MM-dd" />
													<fmt:formatDate value="${localDate}" pattern="dd/MM/yyyy"
														var="formattedDate" /> ${formattedDate}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</main>
					<br>
					<!-- Content for each notification -->
					<div class="content-container">
						<c:forEach var="thongBao" items="${tbs}">
							<div class="content-row" style="display: none;">
								<h3>
									<c:out value="${thongBao.getTieuDe()}" />
								</h3>
								<p>
									<c:out value="${thongBao.getNoiDung()}" />
								</p>
							</div>
						</c:forEach>
					</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		function showDetail(clickedRow) {
			var contentRows = document.querySelectorAll(".content-row");
			contentRows.forEach(function(contentRow) {
				contentRow.style.display = "none";
			});

			var index = clickedRow.rowIndex - 1; // Adjust for header row
			contentRows[index].style.display = "block";
		}
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>