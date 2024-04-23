<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đăng ký</title>
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

.DanhsachDT {
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
.edit-link {
	background-color: #8F9BE3;
	color: white;
	padding: 5px;
	border-radius: 10px;
	text-decoration: none;
}

.edit-link:hover {
	background-color: #6072E1;
	color: white !important;
	text-decoration: none;
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
					<a href="<%=request.getContextPath()%>/GV_DXDT.jsp"
     				 class="nav-link mt-5 d-inline-block" id="button">Đề xuất đề tài</a>
					<main class="main-panel">
					<h3>Danh sách đề tài</h3>
					<c:if test="${not empty errDK}">
						<div class="alert alert-danger" role="alert">
							${errDK}</div>
					</c:if>
					<div class="DanhsachDT">

						<table class="table table-bordered">
							<thead class="fixed-header">
								<tr>
									<th scope="col">Mã Đề Tài</th>
									<th scope="col">Tên Đề Tài</th>
									<th scope="col">Ghi Chú</th>
									
									<th scope="col">Kinh phí dự kiến</th>
									
									<th scope="col">Trạng Thái Đề Tài</th>
									
									<th scope="col">Thao Tác</th>
									
								</tr>
							</thead>
							<tbody>
								<!-- Dữ liệu đề tài -->
								<c:forEach var="dt" items="${dtai}">

									<tr>
										<td><c:out value="${dt.getMaDT()}" /></td>
										<td><c:out value="${dt.getTenDeTai()}" /></td>
										<td><c:out value="${dt.getGhiChu()}" /></td>
										
										<td><c:out value="${dt.getKinhPhiDuKien()}" /></td>
										
										<td><c:out value="${dt.getTrangThai()}" /></td>
										<c:if test="${dk}">
										<td>
											<a type="edit-link" class="btn btn-danger"
												href="showdk?id=<c:out value='${dt.getMaDT()}' />">Đăng ký</a>
										</td>
										</c:if>
									</tr>
								</c:forEach>



								<!-- Thêm các hàng khác nếu cần -->
							</tbody>
						</table>
					</div>

					


					



				</main>
				</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>