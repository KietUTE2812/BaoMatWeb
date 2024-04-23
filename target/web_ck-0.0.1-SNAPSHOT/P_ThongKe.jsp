<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thống kê đề tài</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- Thêm thư viện Moment.js từ CDN -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

<style>
.main-panel {
	padding: 20px; /* Thêm padding để không bị lộn màu nền vào mép */
	max-height: 100%
}

.table-container.show {
	display: block;
}

.input-month {
	max-width: 30%;
	margin-left: 20px;
	margin-right: 20px;
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: left;
}

.table-container {
	max-height: 600px; /* Đặt chiều cao tối đa cho phần tbody */
	overflow-y: auto;
	display: none;
}

.fixed-header th {
	position: sticky;
	top: 0;
	background-color: #f5f5f5; /* Màu nền cho header cố định */
}

.table-container td {
	margin-top: 30px;
	max-width: 200px;
	word-wrap: break-word;
	max-width: 200px;
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
					<div class="container-thongke">
						<h2>Thống kê đề tài</h2>
						<c:if test="${not empty errorMessage}">
							<div class="alert alert-danger" role="alert">
								${errorMessage}</div>
						</c:if>

						<!-- Dropdown cho chọn đợt -->
						<label for="dotDuAn">Chọn đợt:</label> <select id="dotDuAn"
							onchange="loadData()">
							<c:forEach var="md" items="${dsmadot}">
								<option value="${md.getMaDot()}">${md.getMaDot()}</option>
								</option>
							</c:forEach>
							<!-- Thêm các đợt khác nếu cần -->
						</select>

						<button class="btn btn-primary" onclick="XuatThongKe()">Xuất
							thống kê</button>



						<!-- Bảng hiển thị đề tài -->
						<br>
						<div class="table-container">
							<table id="dataTable">
								<thead class="fixed-header">
									<tr>
										<th>Mã Đề Tài</th>
										<th>Tên Đề Tài</th>
										<th>Ghi Chú</th>
										<th>Ngày Thực Hiện</th>
										<th>Ngày Kết Thúc</th>
										<th>Kinh Phí Dự Kiến</th>
										<th>Kết Quả</th>
										<th>Trạng Thái</th>
										<th>Link Nộp Bài</th>
										<th>Ngày Nộp</th>
									</tr>
								</thead>
								<tbody id="dataBody">

								</tbody>
							</table>
						</div>
					</div>
				</main>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Thêm thư viện Moment.js từ CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

	<script>
		function XuatThongKe() {

			var selectedDot = document.getElementById("dotDuAn").value;
			alert("Xuất thống kê cho đợt: " + selectedDot);
			$.ajax({
				type : "GET",
				url : "dsdetaithongke",
				data : {
					selectedDot : selectedDot
				},
				success : function(response) {
					var $response = $(response);
					console.log(response);
					console.log(response);
					// Lặp qua từng hàng trong bảng
					$response.find('tr').each(
							function() {
								var $row = $(this);

								// Xử lý định dạng ngày sử dụng Moment.js (cần cài đặt Moment.js)
								var ngayThucHien = moment(
										$row.find('td:eq(3)').text()).format(
										"DD/MM/YYYY");
								var ngayKetThuc = moment(
										$row.find('td:eq(4)').text()).format(
										"DD/MM/YYYY");

								// Thay thế nội dung của cột ngày
								$row.find('td:eq(3)').text(ngayThucHien);
								$row.find('td:eq(4)').text(ngayKetThuc);
							});

					// Thay thế nội dung của tbody
					$("#dataBody").html($response);
					$(".table-container").addClass("show");
				},
				error : function(error) {
					console.log(error);
				}
			});
		}
	</script>
	<script>
		$(document).ready(function() {
			// Bắt sự kiện khi giá trị của select thay đổi
			$("#dotDuAn").change(function() {
				var selectedDot = $(this).val();

				// Gửi giá trị lên server thông qua AJAX
				$.ajax({
					type : "POST",
					url : "dsdetaithongke", // Đường dẫn của servlet hoặc controller để xử lý lưu vào session
					data : {
						selectedDot : selectedDot
					},
					success : function(response) {
						console.log("Đã lưu giá trị vào session");
					},
					error : function(error) {
						console.log(error);
					}
				});
			});
		});
	</script>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>